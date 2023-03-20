package com.example.taller1_compumovil.model;

import java.io.Serializable;

public class Pais implements Serializable {
    private String name;
    private String SubRegion;
    private String alpha2Code;
    private String flagPng;

    public Pais(String name, String subRegion, String alpha2Code, String flagPng) {
        this.name = name;
        this.SubRegion = subRegion;
        this.alpha2Code = alpha2Code;
        this.flagPng = flagPng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getFlag() {
        return flagPng;
    }

    public void setFlag(String flag) {
        this.flagPng = flag;
    }

    public String getSubRegion() {
        return SubRegion;
    }

    public void setSubRegion(String subRegion) {
        SubRegion = subRegion;
    }
}
