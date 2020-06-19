package com.example.corona.services.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.corona.services.model.CountryList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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

        coronaServices.DetailsInfo(country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CountryList>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CountryList countryList) {
                        data.setValue(countryList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("Error", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return data;
    }

}
