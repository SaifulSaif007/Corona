package com.example.corona.services.repository;

import com.example.corona.services.model.All;
import com.example.corona.services.model.CountryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoronaServices {

    @GET("all")
    Call<All> getAllInfo();

    @GET("countries")
    Call<List<CountryList>> GetCountryList(
    @Query("sort") String type
    );


}
