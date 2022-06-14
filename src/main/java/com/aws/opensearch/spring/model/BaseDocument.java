package com.aws.opensearch.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseDocument {

    @JsonProperty("ori-id")
    private String oriId;
    private String id;
    @JsonProperty("is-new")
    private Boolean isNew;
    @JsonProperty("is-update")
    private Boolean isUpdate;
    private String title;
    private String description;
    @JsonProperty("created-date-time")
    private String createdDateTime;
    @JsonProperty("updated-date-time")
    private String updatedDateTime;

    public String getOriId() {
        return oriId;
    }

    public void setOriId(String oriId) {
        this.oriId = oriId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        isNew = isNew;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        isUpdate = isUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(String updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
