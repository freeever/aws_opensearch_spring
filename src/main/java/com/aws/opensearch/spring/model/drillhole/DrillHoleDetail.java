package com.aws.opensearch.spring.model.drillhole;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DrillHoleDetail implements Serializable {

    @JsonProperty("hole-type")
    private String holeType;
    @JsonProperty("endm-hole-id")
    private String endmHoleId;
    @JsonProperty("company-hole-id")
    private String commpanyHoleId;
    private String township;
    @JsonProperty("utm-datum")
    private String utmDatum;
    @JsonProperty("utm-zone")
    private String utmZone;
    private String easting;
    private String northing;
    private int dip;
    private int azumuth;
    @JsonProperty("overburden-depth")
    private double overburdenDepth;
    private double length;
    private String elements;
    private String comments;
    @JsonProperty("drill-core-storage-site")
    private String drillCoreStorageSite;

    public String getHoleType() {
        return holeType;
    }

    public void setHoleType(String holeType) {
        this.holeType = holeType;
    }

    public String getEndmHoleId() {
        return endmHoleId;
    }

    public void setEndmHoleId(String endmHoleId) {
        this.endmHoleId = endmHoleId;
    }

    public String getCommpanyHoleId() {
        return commpanyHoleId;
    }

    public void setCommpanyHoleId(String commpanyHoleId) {
        this.commpanyHoleId = commpanyHoleId;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getUtmDatum() {
        return utmDatum;
    }

    public void setUtmDatum(String utmDatum) {
        this.utmDatum = utmDatum;
    }

    public String getUtmZone() {
        return utmZone;
    }

    public void setUtmZone(String utmZone) {
        this.utmZone = utmZone;
    }

    public String getEasting() {
        return easting;
    }

    public void setEasting(String easting) {
        this.easting = easting;
    }

    public String getNorthing() {
        return northing;
    }

    public void setNorthing(String northing) {
        this.northing = northing;
    }

    public int getDip() {
        return dip;
    }

    public void setDip(int dip) {
        this.dip = dip;
    }

    public int getAzumuth() {
        return azumuth;
    }

    public void setAzumuth(int azumuth) {
        this.azumuth = azumuth;
    }

    public double getOverburdenDepth() {
        return overburdenDepth;
    }

    public void setOverburdenDepth(double overburdenDepth) {
        this.overburdenDepth = overburdenDepth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDrillCoreStorageSite() {
        return drillCoreStorageSite;
    }

    public void setDrillCoreStorageSite(String drillCoreStorageSite) {
        this.drillCoreStorageSite = drillCoreStorageSite;
    }
}
