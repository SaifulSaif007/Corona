package com.example.corona.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.corona.services.model.CountryList;
import com.example.corona.services.repository.CoronaServiceRepository_Details;

public class CoronaServiceViewModel_DetailsInfo extends AndroidViewModel {

    public CoronaServiceViewModel_DetailsInfo(@NonNull Application application) {
        super(application);
    }

    public LiveData<CountryList> getDetailedInfo(String country){
        return CoronaServiceRepository_Details.getInstance().getDetailedInfo(country);
    }
}
