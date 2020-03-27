package com.example.corona.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.corona.R;
import com.example.corona.databinding.ActivityMainBinding;
import com.example.corona.services.model.All;
import com.example.corona.viewmodel.CoronaServiceViewModel_All;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    CoronaServiceViewModel_All serviceViewModel_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        serviceViewModel_all = ViewModelProviders.of(this).get(CoronaServiceViewModel_All.class);


        observeViewModel(serviceViewModel_all);

    }


    private void observeViewModel(CoronaServiceViewModel_All serviceViewModel_all) {
        serviceViewModel_all.allServiceObserver().observe(this, all -> {

            if(all != null){
                activityMainBinding.setAll(all);
            }
        });
    }
}
