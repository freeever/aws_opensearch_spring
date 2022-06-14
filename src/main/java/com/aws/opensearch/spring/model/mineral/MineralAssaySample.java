package com.aws.opensearch.spring.model.mineral;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MineralAssaySample implements Serializable {

    private static final long serialVersionUID = -5118721532992571514L;

    private String commodity;
    @JsonProperty("analytical-method")
    private String analyticalMethod;
    @JsonProperty("digestion-method")
    private String digestionMethod;
    private String result;
    private String unit;
    private String limit;
    private String qualifier;

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getAnalyticalMethod() {
        return analyticalMethod;
    }

    public void setAnalyticalMethod(String analyticalMethod) {
        this.analyticalMethod = analyticalMethod;
    }

    public String getDigestionMethod() {
        return digestionMethod;
    }

    public void setDigestionMethod(String digestionMethod) {
        this.digestionMethod = digestionMethod;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }
}
