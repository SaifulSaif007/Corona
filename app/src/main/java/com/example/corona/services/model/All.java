package com.example.corona.services.model;

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

    private int activeCases;

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }
}
