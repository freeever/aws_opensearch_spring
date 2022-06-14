package com.aws.opensearch.spring.model.mineral;

import com.aws.opensearch.spring.model.BaseDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class MineralInventory extends BaseDocument implements Serializable {

    private static final long serialVersionUID = 2175831789250629240L;

    @JsonProperty("record-no")
    private String recordNo;
    @JsonProperty("record-names")
    private List<String> recordNames;
    @JsonProperty("related-record-type")
    private String relatedRecordType;
    @JsonProperty("related-records")
    private String relatedRecords;
    @JsonProperty("record-status")
    private String recordStatus;
    @JsonProperty("term-of-use")
    private String termOfUse;
    @JsonProperty("exploration-history")
    private String explorationHistory;

    private MineralGeology geology;

    @JsonProperty("primary-commodities")
    private List<MineralCommodity> primaryCommodities;
    @JsonProperty("secondary-commodities")
    private List<MineralCommodity> secondaryCommodities;
    private List<MineralLocation> locations;
    @JsonProperty("assessment-workon-files")
    private List<AssessmentWorkonFile> assessmentWorkonFiles;
    private List<MineralLithology> lithologies;
    private List<Mineralization> mineralizations;
    @JsonProperty("assay-samples")
    private List<MineralAssaySample> assaySamples;
    @JsonProperty("mineral-record-details")
    private List<MineralRecordDetail> mineralRecordDetails;
    private List<MineralReference> references;

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public List<String> getRecordNames() {
        return recordNames;
    }

    public void setRecordNames(List<String> recordNames) {
        this.recordNames = recordNames;
    }

    public String getRelatedRecordType() {
        return relatedRecordType;
    }

    public void setRelatedRecordType(String relatedRecordType) {
        this.relatedRecordType = relatedRecordType;
    }

    public String getRelatedRecords() {
        return relatedRecords;
    }

    public void setRelatedRecords(String relatedRecords) {
        this.relatedRecords = relatedRecords;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getTermOfUse() {
        return termOfUse;
    }

    public String getExplorationHistory() {
        return explorationHistory;
    }

    public void setExplorationHistory(String explorationHistory) {
        this.explorationHistory = explorationHistory;
    }

    public void setTermOfUse(String termOfUse) {
        this.termOfUse = termOfUse;
    }

    public MineralGeology getGeology() {
        return geology;
    }

    public void setGeology(MineralGeology geology) {
        this.geology = geology;
    }

    public List<MineralCommodity> getPrimaryCommodities() {
        return primaryCommodities;
    }

    public void setPrimaryCommodities(List<MineralCommodity> primaryCommodities) {
        this.primaryCommodities = primaryCommodities;
    }

    public List<MineralCommodity> getSecondaryCommodities() {
        return secondaryCommodities;
    }

    public void setSecondaryCommodities(List<MineralCommodity> secondaryCommodities) {
        this.secondaryCommodities = secondaryCommodities;
    }

    public List<MineralLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<MineralLocation> locations) {
        this.locations = locations;
    }

    public List<AssessmentWorkonFile> getAssessmentWorkonFiles() {
        return assessmentWorkonFiles;
    }

    public void setAssessmentWorkonFiles(List<AssessmentWorkonFile> assessmentWorkonFiles) {
        this.assessmentWorkonFiles = assessmentWorkonFiles;
    }

    public List<MineralLithology> getLithologies() {
        return lithologies;
    }

    public void setLithologies(List<MineralLithology> lithologies) {
        this.lithologies = lithologies;
    }

    public List<Mineralization> getMineralizations() {
        return mineralizations;
    }

    public void setMineralizations(List<Mineralization> mineralizations) {
        this.mineralizations = mineralizations;
    }

    public List<MineralAssaySample> getAssaySamples() {
        return assaySamples;
    }

    public void setAssaySamples(List<MineralAssaySample> assaySamples) {
        this.assaySamples = assaySamples;
    }

    public List<MineralRecordDetail> getMineralRecordDetails() {
        return mineralRecordDetails;
    }

    public void setMineralRecordDetails(List<MineralRecordDetail> mineralRecordDetails) {
        this.mineralRecordDetails = mineralRecordDetails;
    }

    public List<MineralReference> getReferences() {
        return references;
    }

    public void setReferences(List<MineralReference> references) {
        this.references = references;
    }
}
