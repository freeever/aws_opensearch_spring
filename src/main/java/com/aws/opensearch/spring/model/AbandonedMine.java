package com.aws.opensearch.spring.model;

import java.io.Serializable;

public class AbandonedMine extends BaseDocument implements Serializable {

    private static final long serialVersionUID = -8908585342895906050L;

    private String abandonedMineIdentifier;
    private String officialName;

    public String getAbandonedMineIdentifier() {
        return abandonedMineIdentifier;
    }

    public void setAbandonedMineIdentifier(String abandonedMineIdentifier) {
        this.abandonedMineIdentifier = abandonedMineIdentifier;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }
}
