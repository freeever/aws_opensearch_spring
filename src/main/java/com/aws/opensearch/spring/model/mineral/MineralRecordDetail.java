package com.aws.opensearch.spring.model.mineral;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class MineralRecordDetail implements Serializable {

    private static final long serialVersionUID = 6132742695113417150L;

    private List<MineralClassification> classifications;
    private List<MineralCharacteristic> characteristics;
    @JsonProperty("mineral-zones")
    private List<MineralZone> mineralZones;
    @JsonProperty("siteVisit-information")
    private SiteVisitInformation siteVisitInformation;

    public List<MineralClassification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<MineralClassification> classifications) {
        this.classifications = classifications;
    }

    public List<MineralCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<MineralCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public List<MineralZone> getMineralZones() {
        return mineralZones;
    }

    public void setMineralZones(List<MineralZone> mineralZones) {
        this.mineralZones = mineralZones;
    }

    public SiteVisitInformation getSiteVisitInformation() {
        return siteVisitInformation;
    }

    public void setSiteVisitInformation(SiteVisitInformation siteVisitInformation) {
        this.siteVisitInformation = siteVisitInformation;
    }
}
