package com.aws.opensearch.spring.model.mineral;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MineralLocation implements Serializable {

    private static final long serialVersionUID = -1133558215050815998L;

    @JsonProperty("deposit-name")
    private String depositName;
    @JsonProperty("deposit-status")
    private String depositStatus;
    @JsonProperty("primary-township")
    private String primaryTownship;
    @JsonProperty("location-method")
    private String locationMethod;
    @JsonProperty("rgp-district")
    private String rgpDistrict;
    @JsonProperty("point-location")
    private String pointLocation;
    @JsonProperty("utm-datum")
    private String utmDatum;
    @JsonProperty("utm-zone")
    private String utmZone;
    @JsonProperty("utm-easting")
    private String utmEasting;
    @JsonProperty("utm-northing")
    private String utmNorthing;

    private String latitude;
    private String longitude;
    @JsonProperty("resident-geologist-district")
    private String residentGeologistDistrict;
    @JsonProperty("nts-grid")
    private String ntsGrid;
    @JsonProperty("access-description")
    private String accessDescription;

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(String depositStatus) {
        this.depositStatus = depositStatus;
    }

    public String getPrimaryTownship() {
        return primaryTownship;
    }

    public void setPrimaryTownship(String primaryTownship) {
        this.primaryTownship = primaryTownship;
    }

    public String getLocationMethod() {
        return locationMethod;
    }

    public void setLocationMethod(String locationMethod) {
        this.locationMethod = locationMethod;
    }

    public String getRgpDistrict() {
        return rgpDistrict;
    }

    public void setRgpDistrict(String rgpDistrict) {
        this.rgpDistrict = rgpDistrict;
    }

    public String getPointLocation() {
        return pointLocation;
    }

    public void setPointLocation(String pointLocation) {
        this.pointLocation = pointLocation;
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

    public String getUtmEasting() {
        return utmEasting;
    }

    public void setUtmEasting(String utmEasting) {
        this.utmEasting = utmEasting;
    }

    public String getUtmNorthing() {
        return utmNorthing;
    }

    public void setUtmNorthing(String utmNorthing) {
        this.utmNorthing = utmNorthing;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getResidentGeologistDistrict() {
        return residentGeologistDistrict;
    }

    public void setResidentGeologistDistrict(String residentGeologistDistrict) {
        this.residentGeologistDistrict = residentGeologistDistrict;
    }

    public String getNtsGrid() {
        return ntsGrid;
    }

    public void setNtsGrid(String ntsGrid) {
        this.ntsGrid = ntsGrid;
    }

    public String getAccessDescription() {
        return accessDescription;
    }

    public void setAccessDescription(String accessDescription) {
        this.accessDescription = accessDescription;
    }
}
