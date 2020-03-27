package com.example.corona.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.corona.services.model.All;
import com.example.corona.services.repository.CoronaServiceRepository_All;

public class CoronaServiceViewModel_All extends AndroidViewModel {

    public CoronaServiceViewModel_All(@NonNull Application application) {
        super(application);
    }


    public LiveData<All> allServiceObserver(){
        return CoronaServiceRepository_All.getInstance().getCoronaUpdate_all();
    }
}
