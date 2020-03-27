package com.example.corona.services.repository;

import com.example.corona.services.model.All;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaServices {

    @GET("all")
    Call<All> getAllInfo();


}
