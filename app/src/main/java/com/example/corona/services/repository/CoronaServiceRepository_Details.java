package com.example.corona.services.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.corona.services.model.CountryList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaServiceRepository_Details {

    public static CoronaServiceRepository_Details serviceRepositoryDetails;

    public static CoronaServiceRepository_Details getInstance(){
        if(serviceRepositoryDetails == null){
            serviceRepositoryDetails = new CoronaServiceRepository_Details();
        }
        return serviceRepositoryDetails;
    }

    private CoronaServices coronaServices;

    private CoronaServiceRepository_Details(){
        coronaServices = RetrofitService.cteateService(CoronaServices.class);
    }


    public LiveData<CountryList> getDetailedInfo(String country){
        final MutableLiveData<CountryList> data = new MutableLiveData<>();

        coronaServices.DetailsInfo(country).enqueue(new Callback<CountryList>() {
            @Override
            public void onResponse(Call<CountryList> call, Response<CountryList> response) {
                data.setValue( response.body() );
            }

            @Override
            public void onFailure(Call<CountryList> call, Throwable t) {
                Log.e("error", "" + t.getMessage());
            }
        });

        return data;
    }

}
