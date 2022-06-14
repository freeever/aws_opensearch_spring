package com.aws.opensearch.spring.model.mineral;

import java.io.Serializable;

public class MineralCommodity implements Serializable {

    private static final long serialVersionUID = 9162921742171851931L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
