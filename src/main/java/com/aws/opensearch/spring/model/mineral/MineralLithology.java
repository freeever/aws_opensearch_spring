package com.aws.opensearch.spring.model.mineral;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MineralLithology implements Serializable {

    private static final long serialVersionUID = 3959660647637514953L;

    @JsonProperty("rock-type")
    private String rockType;
    private String rank;
    private String composition;
    private String texture;
    private String relationship;

    public String getRockType() {
        return rockType;
    }

    public void setRockType(String rockType) {
        this.rockType = rockType;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
