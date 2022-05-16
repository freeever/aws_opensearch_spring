package com.aws.opensearch.spring.common;

public enum IndexType {
    AbandonedMine("abandoned-mine"),
    Assessment("assessment"),
    DrillHole("drill-hole"),
    MineralInventory("mineral-inventory"),
    Publication("publication");

    private String name;

    IndexType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static IndexType valueOfName(String indexName) {
        for (IndexType v : values()) {
            if (v.name.equals(indexName)) {
                return v;
            }
        }
        return null;
    }
}
