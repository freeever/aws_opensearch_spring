package com.aws.opensearch.spring.model;

import java.io.Serializable;

public class DrillHole extends BaseDocument implements Serializable {

    private static final long serialVersionUID = 1421106392657326628L;

    private String company;
    private String nts;
    private String townshipOrArea;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNts() {
        return nts;
    }

    public void setNts(String nts) {
        this.nts = nts;
    }

    public String getTownshipOrArea() {
        return townshipOrArea;
    }

    public void setTownshipOrArea(String townshipOrArea) {
        this.townshipOrArea = townshipOrArea;
    }
}
