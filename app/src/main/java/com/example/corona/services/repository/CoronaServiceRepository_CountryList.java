package com.example.corona.services.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.corona.services.model.CountryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaServiceRepository_CountryList {

    private static CoronaServiceRepository_CountryList repository_countryList;

    public static CoronaServiceRepository_CountryList getInstance(){
        if(repository_countryList == null){
            repository_countryList = new CoronaServiceRepository_CountryList();
        }
        return repository_countryList;
    }

    private CoronaServices coronaServices;

    private CoronaServiceRepository_CountryList(){
        coronaServices = RetrofitService.cteateService(CoronaServices.class);
    }

    public LiveData<List<CountryList>> getCountry(){
        final MutableLiveData<List<CountryList>> data = new MutableLiveData<>();

        coronaServices.GetCountryList("country").enqueue(new Callback<List<CountryList>>() {
            @Override
            public void onResponse(Call<List<CountryList>> call, Response<List<CountryList>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CountryList>> call, Throwable t) {
                Log.e("error", "" + t.getMessage());
            }
        });

        return data;
    }
}
