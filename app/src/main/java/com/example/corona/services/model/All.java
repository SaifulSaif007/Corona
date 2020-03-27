package com.example.corona.services.model;

public class All {


    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("recovered")
    private String recovered;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("deaths")
    private String deaths;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("cases")
    private String cases;

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }
}
