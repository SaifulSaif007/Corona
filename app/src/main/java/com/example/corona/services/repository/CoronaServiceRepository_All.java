package com.example.corona.services.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.corona.services.model.All;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaServiceRepository_All {

    private static CoronaServiceRepository_All coronaServiceRepositoryAll;

    public static CoronaServiceRepository_All getInstance(){

        if(coronaServiceRepositoryAll == null){
            coronaServiceRepositoryAll = new CoronaServiceRepository_All();
        }
        return coronaServiceRepositoryAll;
    }


    private CoronaServices coronaServices;

    private CoronaServiceRepository_All(){
        coronaServices = RetrofitService.cteateService(CoronaServices.class);
    }



    public LiveData<All> getCoronaUpdate_all(){

        final MutableLiveData<All> data = new MutableLiveData<>();

        coronaServices.getAllInfo().enqueue(new Callback<All>() {
            @Override
            public void onResponse(Call<All> call, Response<All> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<All> call, Throwable t) {
                Log.e("error", "" + t.getMessage());
            }
        });

        return data;
    }
}
