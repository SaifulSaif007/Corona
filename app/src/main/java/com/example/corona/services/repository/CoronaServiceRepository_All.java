package com.example.corona.services.repository;



import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.corona.services.model.All;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.SafeObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
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
        coronaServices.getAllInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<All>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull All all) {
                        data.setValue(all);
                        Log.e("data", "" + all.getActiveCases());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("Error", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("com", "completed");
                    }
                });

        return data;
    }
}
