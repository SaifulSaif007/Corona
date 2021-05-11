package com.example.corona.services.model;

import com.google.gson.annotations.SerializedName;

public class All {


    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("recovered")
    private long recovered;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("deaths")
    private long deaths;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("cases")
    private long cases;
    @com.google.gson.annotations.Expose
    @SerializedName("active")
    private long activeCases;
    @com.google.gson.annotations.Expose
    @SerializedName("critical")
    private long critical;
    @com.google.gson.annotations.Expose
    @SerializedName("tests")
    private long TotalTests;
    @com.google.gson.annotations.Expose
    @SerializedName("affectedCountries")
    private long affectedCountries;


    public long getRecovered() {
        return recovered;
    }

    public long getDeaths() {
        return deaths;
    }

    public long getCases() {
        return cases;
    }

    public long getActiveCases() {
        return activeCases;
    }

    public long getCritical() {
        return critical;
    }

    public long getTotalTests() {
        return TotalTests;
    }

    public long getAffectedCountries() {
        return affectedCountries;
    }
}
