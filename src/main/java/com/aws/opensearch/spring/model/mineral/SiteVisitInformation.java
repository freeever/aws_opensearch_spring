package com.aws.opensearch.spring.model.mineral;

import java.io.Serializable;

public class SiteVisitInformation implements Serializable {

    private static final long serialVersionUID = -2305588802052915583L;

    private String date;
    private String geologist;
    private String notes;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGeologist() {
        return geologist;
    }

    public void setGeologist(String geologist) {
        this.geologist = geologist;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
