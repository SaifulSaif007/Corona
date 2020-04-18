package com.example.corona.services.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class All {


    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("recovered")
    private int recovered;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("deaths")
    private int deaths;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("cases")
    private int cases;
    @com.google.gson.annotations.Expose
    @SerializedName("active")
    private int activeCases;
    @com.google.gson.annotations.Expose
    @SerializedName("critical")
    private int critical;
    @com.google.gson.annotations.Expose
    @SerializedName("tests")
    private int TotalTests;
    @com.google.gson.annotations.Expose
    @SerializedName("affectedCountries")
    private int affectedCountries;


    public int getRecovered() {
        return recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getCases() {
        return cases;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public int getCritical() {
        return critical;
    }

    public int getTotalTests() {
        return TotalTests;
    }

    public int getAffectedCountries() {
        return affectedCountries;
    }
}
