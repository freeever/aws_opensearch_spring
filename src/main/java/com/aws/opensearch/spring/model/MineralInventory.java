package com.aws.opensearch.spring.model;

import java.io.Serializable;

public class MineralInventory extends BaseDocument implements Serializable {

    private static final long serialVersionUID = 2175831789250629240L;

    private String recordName;
    private String relatedRecordType;
    private String recordStatus;

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRelatedRecordType() {
        return relatedRecordType;
    }

    public void setRelatedRecordType(String relatedRecordType) {
        this.relatedRecordType = relatedRecordType;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
