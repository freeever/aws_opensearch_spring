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
}
