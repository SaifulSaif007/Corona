package com.example.corona.services.repository;

import com.example.corona.services.model.All;
import com.example.corona.services.model.CountryList;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CoronaServices {

    @GET("all")
    Observable<All> getAllInfo();

    @GET("countries")
    Observable<List<CountryList>> GetCountryList(
    @Query("sort") String type);

    @GET("countries/{country}")
    Observable<CountryList> DetailsInfo(@Path("country") String country);

}
