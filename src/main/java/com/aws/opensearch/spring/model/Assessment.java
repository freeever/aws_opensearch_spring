package com.aws.opensearch.spring.model;

import java.io.Serializable;

public class Assessment extends BaseDocument implements Serializable {

    private static final long serialVersionUID = -4656746440187659239L;

    private String assessmentFile;
    private String afroNumber;
    private String residentGeologistDistrict;

    public String getAssessmentFile() {
        return assessmentFile;
    }

    public void setAssessmentFile(String assessmentFile) {
        this.assessmentFile = assessmentFile;
    }

    public String getAfroNumber() {
        return afroNumber;
    }

    public void setAfroNumber(String afroNumber) {
        this.afroNumber = afroNumber;
    }

    public String getResidentGeologistDistrict() {
        return residentGeologistDistrict;
    }

    public void setResidentGeologistDistrict(String residentGeologistDistrict) {
        this.residentGeologistDistrict = residentGeologistDistrict;
    }
}
