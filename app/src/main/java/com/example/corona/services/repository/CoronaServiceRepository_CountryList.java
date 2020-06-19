package com.example.corona.services.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.corona.services.model.CountryList;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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

        coronaServices.GetCountryList("country")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CountryList>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<CountryList> countryLists) {
                        data.setValue(countryLists);
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
