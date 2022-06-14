package com.aws.opensearch.spring.model.mineral;

import java.io.Serializable;

public class MineralClassification implements Serializable {

    private static final long serialVersionUID = -4410577544477085756L;

    private String rank;
    private String classfication;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getClassfication() {
        return classfication;
    }

    public void setClassfication(String classfication) {
        this.classfication = classfication;
    }
}
