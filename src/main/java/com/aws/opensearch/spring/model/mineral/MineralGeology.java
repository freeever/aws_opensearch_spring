package com.aws.opensearch.spring.model.mineral;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MineralGeology implements Serializable {

    private static final long serialVersionUID = -7144959780964033696L;

    private String province;
    @JsonProperty("sub-province")
    private String subProvince;
    private String terrane;
    private String belt;
    @JsonProperty("tectonic-assemblage")
    private String tectonicAssemblage;
    @JsonProperty("geological-age")
    private String geologicalAge;
    @JsonProperty("metamorphism-type")
    private String metamorphismType;
    @JsonProperty("metamorphism-grade")
    private String metamorphismGrade;
    private String comments;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSubProvince() {
        return subProvince;
    }

    public void setSubProvince(String subProvince) {
        this.subProvince = subProvince;
    }

    public String getTerrane() {
        return terrane;
    }

    public void setTerrane(String terrane) {
        this.terrane = terrane;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getTectonicAssemblage() {
        return tectonicAssemblage;
    }

    public void setTectonicAssemblage(String tectonicAssemblage) {
        this.tectonicAssemblage = tectonicAssemblage;
    }

    public String getGeologicalAge() {
        return geologicalAge;
    }

    public void setGeologicalAge(String geologicalAge) {
        this.geologicalAge = geologicalAge;
    }

    public String getMetamorphismType() {
        return metamorphismType;
    }

    public void setMetamorphismType(String metamorphismType) {
        this.metamorphismType = metamorphismType;
    }

    public String getMetamorphismGrade() {
        return metamorphismGrade;
    }

    public void setMetamorphismGrade(String metamorphismGrade) {
        this.metamorphismGrade = metamorphismGrade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
