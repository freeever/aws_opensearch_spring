package com.aws.opensearch.spring.model.mineral;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Mineralization implements Serializable {

    private static final long serialVersionUID = 7180941377907324117L;
    private String rank;
    @JsonProperty("mineral-name")
    private String mineralName;
    @JsonProperty("mineralization-class")
    private String mineralizationClass;
    @JsonProperty("economic-mineral-type")
    private String economicMineralType;
    @JsonProperty("alteration-mineral-type")
    private String alterationMineralType;
    @JsonProperty("alteration-ranking")
    private String alterationRanking;
    @JsonProperty("alteration-intensity")
    private String alterationIntensity;
    @JsonProperty("alteration-style")
    private String alterationStyle;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMineralName() {
        return mineralName;
    }

    public void setMineralName(String mineralName) {
        this.mineralName = mineralName;
    }

    public String getMineralizationClass() {
        return mineralizationClass;
    }

    public void setMineralizationClass(String mineralizationClass) {
        this.mineralizationClass = mineralizationClass;
    }

    public String getEconomicMineralType() {
        return economicMineralType;
    }

    public void setEconomicMineralType(String economicMineralType) {
        this.economicMineralType = economicMineralType;
    }

    public String getAlterationMineralType() {
        return alterationMineralType;
    }

    public void setAlterationMineralType(String alterationMineralType) {
        this.alterationMineralType = alterationMineralType;
    }

    public String getAlterationRanking() {
        return alterationRanking;
    }

    public void setAlterationRanking(String alterationRanking) {
        this.alterationRanking = alterationRanking;
    }

    public String getAlterationIntensity() {
        return alterationIntensity;
    }

    public void setAlterationIntensity(String alterationIntensity) {
        this.alterationIntensity = alterationIntensity;
    }

    public String getAlterationStyle() {
        return alterationStyle;
    }

    public void setAlterationStyle(String alterationStyle) {
        this.alterationStyle = alterationStyle;
    }
}
