package com.aws.opensearch.spring.model.drillhole;

import com.aws.opensearch.spring.model.BaseDocument;
import com.aws.opensearch.spring.model.MinistryContactInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class DrillHole extends BaseDocument implements Serializable {

    private static final long serialVersionUID = 1421106392657326628L;

    private DrillHoleSummary summary;
    private List<DrillHoleDetail> details;
    @JsonProperty("terms-of-use")
    private String termsOfUse;
    private MinistryContactInfo contact;

    public DrillHoleSummary getSummary() {
        return summary;
    }

    public void setSummary(DrillHoleSummary summary) {
        this.summary = summary;
    }

    public List<DrillHoleDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DrillHoleDetail> details) {
        this.details = details;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public MinistryContactInfo getContact() {
        return contact;
    }

    public void setContact(MinistryContactInfo contact) {
        this.contact = contact;
    }
}
