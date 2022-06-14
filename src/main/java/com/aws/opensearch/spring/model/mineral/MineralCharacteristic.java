package com.aws.opensearch.spring.model.mineral;

import java.io.Serializable;

public class MineralCharacteristic implements Serializable {

    private static final long serialVersionUID = -5992967525101039021L;

    private String rank;
    private String characteristic;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}
