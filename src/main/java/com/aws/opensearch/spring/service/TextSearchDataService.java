package com.aws.opensearch.spring.service;

import com.aws.opensearch.spring.model.textsearch.AccessTokenResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TextSearchDataService {

    private static final Logger logger = LoggerFactory.getLogger(TextSearchDataService.class);

    private RestTemplate restTemplate;
    private String publicationTokenUrl;
    private String publicationDataUrl;

    @Autowired
    public TextSearchDataService(RestTemplate restTemplate,
                                 @Value("${service.url.publication.token}") String publicationTokenUrl,
                                 @Value("${service.url.publication.data}") String publicationDatanUrl) {
        this.restTemplate = restTemplate;
        this.publicationTokenUrl = publicationTokenUrl;
        this.publicationDataUrl = publicationDatanUrl;
    }

    /**
     * Retrieve the following types of geology information and update the Elasticsearch indexes:
     *   - Publication
     *   - Drill Hole
     *   - Assessment
     *   - Mineral Inventory
     *   - Abandoned Mines
     */
    public void updateTextSearchIndex() {
        this.updatePublicationIndex();
    }

    /**
     * Retrieve data and update publication index
     */
    private void updatePublicationIndex() {
        AccessTokenResponse accessToken = this.getAccessToken(this.publicationTokenUrl);
        if (accessToken == null || StringUtils.isBlank(accessToken.getAccessToken())) {
            logger.warn("Access Token for publication is empty. Do nothing.");
            return;
        }
    }

    /**
     * Get the access token which will be used for retrieving business data
     * @param url
     * @return
     */
    private AccessTokenResponse getAccessToken(String url) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("grant_type", "client_credentials");
            return restTemplate.postForObject(url, null, AccessTokenResponse.class, params);
        } catch (Exception ex) {
            logger.error("Failed to get access token for retrieving publication data.", ex);
        }
        return null;
    }


}
