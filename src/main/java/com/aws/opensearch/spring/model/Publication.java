package com.aws.opensearch.spring.model;

import java.io.Serializable;

public class Publication extends BaseDocument implements Serializable {

    private static final long serialVersionUID = 9094108161568721431L;

    private String title;
    private String publicationYear;
    private String type;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
