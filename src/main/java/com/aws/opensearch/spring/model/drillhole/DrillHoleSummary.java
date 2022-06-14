package com.aws.opensearch.spring.model.drillhole;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DrillHoleSummary implements Serializable {

    private String company;
    private String nts;
    private String township;
    @JsonProperty("resident-geologist-district")
    private String residentGeologistDistrict;
    @JsonProperty("year-drilled")
    private String yearDrilled;
    @JsonProperty("assessment-file")
    private String assessmentFile;

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

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getResidentGeologistDistrict() {
        return residentGeologistDistrict;
    }

    public void setResidentGeologistDistrict(String residentGeologistDistrict) {
        this.residentGeologistDistrict = residentGeologistDistrict;
    }

    public String getYearDrilled() {
        return yearDrilled;
    }

    public void setYearDrilled(String yearDrilled) {
        this.yearDrilled = yearDrilled;
    }

    public String getAssessmentFile() {
        return assessmentFile;
    }

    public void setAssessmentFile(String assessmentFile) {
        this.assessmentFile = assessmentFile;
    }
}
