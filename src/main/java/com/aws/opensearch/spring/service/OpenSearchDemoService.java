package com.aws.opensearch.spring.service;

import com.aws.opensearch.spring.common.IndexType;
import com.aws.opensearch.spring.model.AbandonedMine;
import com.aws.opensearch.spring.model.Assessment;
import com.aws.opensearch.spring.model.BaseDocument;
import com.aws.opensearch.spring.model.DrillHole;
import com.aws.opensearch.spring.model.GeologyDocumentRequest;
import com.aws.opensearch.spring.model.MineralInventory;
import com.aws.opensearch.spring.model.Publication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.opensearch.action.admin.indices.alias.Alias;
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.search.SearchRequest;
import org.opensearch.action.search.SearchResponse;
import org.opensearch.action.search.SearchType;
import org.opensearch.action.support.master.AcknowledgedResponse;
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.indices.CreateIndexResponse;
import org.opensearch.common.settings.Settings;
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OpenSearchDemoService <T extends BaseDocument> {

    private static Logger log = LoggerFactory.getLogger(OpenSearchDemoService.class);

    private RestHighLevelClient client;
    private ObjectMapper objectMapper;

    @Autowired
    public OpenSearchDemoService(RestHighLevelClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public List<BaseDocument> findAllDocuments(String indexName) throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());

        return this.searchDocuments(indexName, sourceBuilder, this.getIndexClass(indexName));
    }

    /**
     * Search Abandoned Mine by its own ID, which comes from original on prem database
     * @param oriId
     * @return
     * @throws IOException
     */
    public AbandonedMine findAbandonedMineByOriId(String oriId) throws IOException {
        log.info("Search Abandoned Mine by ID from original on prem database");

        return (AbandonedMine)findGeoDocumentByOriId(oriId, IndexType.AbandonedMine.getName(), AbandonedMine.class);
    }

    /**
     * Search Assessment by its own ID, which comes from original on prem database
     * @param oriId
     * @return
     * @throws IOException
     */
    public AbandonedMine findAssessmentByOriId(String oriId) throws IOException {
        log.info("Search Assessment by ID from original on prem database");
        return (AbandonedMine)findGeoDocumentByOriId(oriId, IndexType.Assessment.getName(), Assessment.class);
    }

    /**
     * Search Drill Hole by its own ID, which comes from original on prem database
     * @param oriId
     * @return
     * @throws IOException
     */
    public DrillHole findDrillHoleByOriId(String oriId) throws IOException {
        log.info("Search Drill Hole by ID from original on prem database");
        return (DrillHole)findGeoDocumentByOriId(oriId, IndexType.DrillHole.getName(), DrillHole.class);
    }
    /**
     * Search Mineral Inventory by its own ID, which comes from original on prem database
     * @param oriId
     * @return
     * @throws IOException
     */
    public MineralInventory findMineralInventoryByOriId(String oriId) throws IOException {
        log.info("Search Mineral Inventory by ID from original on prem database");
        return (MineralInventory)findGeoDocumentByOriId(oriId, IndexType.MineralInventory.getName(), MineralInventory.class);
    }
    /**
     * Search Publication by its own ID, which comes from original on prem database
     * @param oriId
     * @return
     * @throws IOException
     */
    public Publication findPublicationByOriId(String oriId) throws IOException {
        log.info("Search Publication by ID from original on prem database");
        return (Publication)findGeoDocumentByOriId(oriId, IndexType.Publication.getName(), Publication.class);
    }
    /**
     * Search one of the 5 indexes defined in IndexType by its original id from the on prem database
     * @param oriId
     * @param indexName
     * @param type One of BaseDocument's sub class
     * @return
     * @throws IOException
     */
    private <T extends BaseDocument> BaseDocument findGeoDocumentByOriId(String oriId, String indexName, Class<T> type)
            throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchPhraseQuery("oriId", oriId));
        List<BaseDocument> documents = this.searchDocuments(indexName, sourceBuilder, type);

        return documents.isEmpty() ? null : documents.get(0);
    }

    private <T extends BaseDocument> List<BaseDocument> searchDocuments(
            String indexName, SearchSourceBuilder sourceBuilder, Class<T> type)
        throws IOException {
       SearchRequest searchRequest = new SearchRequest(indexName);
       searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
       searchRequest.source(sourceBuilder);
       // Execute search
       SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

       List<BaseDocument> documents = Stream.of(searchResponse.getHits().getHits())
               .map(searchHint -> {
                   BaseDocument document = objectMapper.convertValue(searchHint.getSourceAsMap(), type);
                   document.setId(searchHint.getId());
                   return document;
               })
               .collect(Collectors.toList());
       return documents;
    }

    /**
     * Add documents to the Geology Ontario search engine (OpenSearch)
     * @param request
     * @return
     * @throws IOException
     */
    public int add(GeologyDocumentRequest request) throws IOException {
        List<BaseDocument> documents = new ArrayList<>();
        // Add Abandoned Mines
        documents.addAll(request.getAbandonedMines());
        int result = addDocuments(documents, IndexType.AbandonedMine);
        documents.clear();

        // Add Assessment
        documents.addAll(request.getAssessments());
        result += addDocuments(documents, IndexType.Assessment);
        documents.clear();

        // Add Drill Hole
        documents.addAll(request.getDrillHoles());
        result += addDocuments(documents, IndexType.DrillHole);
        documents.clear();

        // Add Mineral Inventories
        documents.addAll(request.getMineralInventories());
        result += addDocuments(documents, IndexType.MineralInventory);
        documents.clear();

        // Add Publications
        documents.addAll(request.getPublications());
        result += addDocuments(documents, IndexType.Publication);

        return result;
    }

    public int update(GeologyDocumentRequest request) {
        return 0;
    }

    /**
     * Add Documents for one of the 5 indexes defined in IndexType
     * @param documents
     * @return Number of added documents
     * @throws IOException
     */
    private int addDocuments(List<BaseDocument> documents, IndexType indexType) throws IOException {
        log.info("Add documents of {}", indexType.getName());
        if (documents == null || documents.isEmpty()) {
            return 0;
        }

        List<Map<String, Object>> docMappers = new ArrayList<>();
        for (BaseDocument document : documents) {
            Map<String, Object> docMapper = objectMapper.convertValue(document, Map.class);
            docMappers.add(docMapper);
        }
        return this.addDocuments(indexType, docMappers);
    }

    /**
     * Update Abandoned Mines
     * @param abandonedMines
     * @return Number of added documents
     * @throws IOException
     */
    private int updateAbandonedMines(List<AbandonedMine> abandonedMines) throws IOException {
        log.info("Update Abandoned Mines ...");
        if (abandonedMines == null || abandonedMines.isEmpty()) {
            return 0;
        }

        BulkRequest request = new BulkRequest();
        for (AbandonedMine abandonedMine : abandonedMines) {
            AbandonedMine abandonedMineRetrieved = findAbandonedMineByOriId(abandonedMine.getOriId());
            if (abandonedMineRetrieved == null) {
                continue;
            }

            UpdateRequest updateRequest = new UpdateRequest(IndexType.AbandonedMine.getName(), abandonedMineRetrieved.getId());
            request.add(updateRequest);
        }

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        return response.getItems().length;
    }

    /**
     * Add Geology Ontario data to OpenSearch
     * @param indexType
     * @param docMappers
     * @return
     * @throws IOException
     */
    private int addDocuments(IndexType indexType, List<Map<String, Object>> docMappers) throws IOException {
        BulkRequest request = new BulkRequest();
        IndexRequest indexRequest = null;
        for (Map<String, Object> docMapper : docMappers) {
            indexRequest = new IndexRequest(indexType.getName()).source(docMapper);
            request.add(indexRequest);
        }

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        return response.getItems().length;
    }

    /**
     * Create new index
     * @param name
     * @throws IOException
     */
    public void createIndex(String name) throws IOException {
        // Create a non-default index with custom settings and mappings.
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(name);

        createIndexRequest.settings(Settings.builder() //Specify in the settings how many shards you want in the index.
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 0)
        );
        //Create a set of maps for the index's mappings.
        HashMap<String, String> typeMapping = new HashMap<String,String>();
        typeMapping.put("type", "integer");
        HashMap<String, Object> ageMapping = new HashMap<String, Object>();
        ageMapping.put("age", typeMapping);
        HashMap<String, Object> mapping = new HashMap<String, Object>();
        mapping.put("properties", ageMapping);
        createIndexRequest.mapping(mapping);
        createIndexRequest.alias(new Alias(name + "_alias"));

        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }

    /**
     * Delete an index by name
     * @param name
     * @throws IOException
     */
    public void deleteIndex(String name) throws IOException {
        // Delete an index
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(name); //Index name.
        AcknowledgedResponse deleteIndexResponse = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
    }

    private Class getIndexClass(String indexName) {
        IndexType indexType = IndexType.valueOfName(indexName);
        switch (indexType) {
            case AbandonedMine:
                return AbandonedMine.class;
            case Assessment:
                return Assessment.class;
            case DrillHole:
                return DrillHole.class;
            case MineralInventory:
                return MineralInventory.class;
            case Publication:
                return Publication.class;
            default:
        }

        return null;
    }

}
