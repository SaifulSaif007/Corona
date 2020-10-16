package com.example.corona.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.corona.services.model.CountryList;
import com.example.corona.services.repository.CoronaServiceRepository_CountryList;

import java.util.List;

public class CoronaServiceViewModel_CountryList extends AndroidViewModel {

    public CoronaServiceViewModel_CountryList(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<CountryList>> country = CoronaServiceRepository_CountryList.getInstance().getCountry();

//    public LiveData<List<CountryList>> getCountryList(){
//        return CoronaServiceRepository_CountryList.getInstance().getCountry();
//    }

}
