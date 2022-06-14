package com.aws.opensearch.spring.model.mineral;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AssessmentWorkonFile implements Serializable {

    private static final long serialVersionUID = -2913267703264253011L;

    @JsonProperty("office-file-number")
    private String officeFileNumber;
    @JsonProperty("online-assessment-file-identifier")
    private String onlineAssessmentFileIdentifier;
    @JsonProperty("online-assessment-file-directory")
    private String onlineAssessmentFileDirectory;

    public String getOfficeFileNumber() {
        return officeFileNumber;
    }

    public void setOfficeFileNumber(String officeFileNumber) {
        this.officeFileNumber = officeFileNumber;
    }

    public String getOnlineAssessmentFileIdentifier() {
        return onlineAssessmentFileIdentifier;
    }

    public void setOnlineAssessmentFileIdentifier(String onlineAssessmentFileIdentifier) {
        this.onlineAssessmentFileIdentifier = onlineAssessmentFileIdentifier;
    }

    public String getOnlineAssessmentFileDirectory() {
        return onlineAssessmentFileDirectory;
    }

    public void setOnlineAssessmentFileDirectory(String onlineAssessmentFileDirectory) {
        this.onlineAssessmentFileDirectory = onlineAssessmentFileDirectory;
    }
}
