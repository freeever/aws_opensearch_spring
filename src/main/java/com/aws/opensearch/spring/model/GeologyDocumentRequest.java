package com.aws.opensearch.spring.model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeologyDocumentRequest implements Serializable {

    private static final long serialVersionUID = -3152604714278206464L;

    private List<AbandonedMine> abandonedMines;
    private List<Assessment> assessments;
    private List<DrillHole> drillHoles;
    private List<MineralInventory> mineralInventories;
    private List<Publication> publications;

    public List<AbandonedMine> getAbandonedMines() {
        return abandonedMines == null ? new ArrayList<>() : abandonedMines;
    }

    public void setAbandonedMines(List<AbandonedMine> abandonedMines) {
        this.abandonedMines = abandonedMines;
    }

    public List<Assessment> getAssessments() {
        return assessments == null ? new ArrayList<>() : assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public List<DrillHole> getDrillHoles() {
        return drillHoles == null ? new ArrayList<>() : drillHoles;
    }

    public void setDrillHoles(List<DrillHole> drillHoles) {
        this.drillHoles = drillHoles;
    }

    public List<MineralInventory> getMineralInventories() {
        return mineralInventories == null ? new ArrayList<>() : mineralInventories;
    }

    public void setMineralInventories(List<MineralInventory> mineralInventories) {
        this.mineralInventories = mineralInventories;
    }

    public List<Publication> getPublications() {
        return publications == null ? new ArrayList<>() : publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }
}
