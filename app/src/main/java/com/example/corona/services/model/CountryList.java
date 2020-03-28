package com.example.corona.services.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryList {


    @Expose
    @SerializedName("deathsPerOneMillion")
    private double deathsPerOneMillion;
    @Expose
    @SerializedName("casesPerOneMillion")
    private double casesPerOneMillion;
    @Expose
    @SerializedName("critical")
    private int critical;
    @Expose
    @SerializedName("active")
    private int active;
    @Expose
    @SerializedName("recovered")
    private int recovered;
    @Expose
    @SerializedName("todayDeaths")
    private int todayDeaths;
    @Expose
    @SerializedName("deaths")
    private int deaths;
    @Expose
    @SerializedName("todayCases")
    private int todayCases;
    @Expose
    @SerializedName("cases")
    private int cases;
    @Expose
    @SerializedName("countryInfo")
    private CountryInfo countryInfo;
    @Expose
    @SerializedName("country")
    private String country;

    public double getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(double deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public double getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(double casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static class CountryInfo {
        @Expose
        @SerializedName("iso2")
        private String iso2;
        @Expose
        @SerializedName("iso3")
        private String iso3;
        @Expose
        @SerializedName("flag")
        private String flag;


        public String getIso2() {
            return iso2;
        }

        public void setIso2(String iso2) {
            this.iso2 = iso2;
        }

        public String getIso3() {
            return iso3;
        }

        public void setIso3(String iso3) {
            this.iso3 = iso3;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "CountryInfo{" +
                    "iso2='" + iso2 + '\'' +
                    ", iso3='" + iso3 + '\'' +
                    ", flag='" + flag + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CountryList{" +
                "deathsPerOneMillion=" + deathsPerOneMillion +
                ", casesPerOneMillion=" + casesPerOneMillion +
                ", critical=" + critical +
                ", active=" + active +
                ", recovered=" + recovered +
                ", todayDeaths=" + todayDeaths +
                ", deaths=" + deaths +
                ", todayCases=" + todayCases +
                ", cases=" + cases +
                ", countryInfo=" + countryInfo +
                ", country='" + country + '\'' +
                '}';
    }
}
