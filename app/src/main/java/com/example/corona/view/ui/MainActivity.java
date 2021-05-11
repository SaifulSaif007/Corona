package com.example.corona.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.corona.R;
import com.example.corona.databinding.ActivityMainBinding;
import com.example.corona.view.callback.IMainActivity;
import com.example.corona.viewmodel.CoronaServiceViewModel_All;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    ActivityMainBinding activityMainBinding;
    CoronaServiceViewModel_All serviceViewModel_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        serviceViewModel_all = new ViewModelProvider(this).get(CoronaServiceViewModel_All.class);
        Objects.requireNonNull(getSupportActionBar()).hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        activityMainBinding.progressBar.setVisibility(View.VISIBLE);
        observeViewModel(serviceViewModel_all);
        activityMainBinding.setIMainActivityCallBack(this);

    }


    private void observeViewModel(CoronaServiceViewModel_All serviceViewModel_all) {
        serviceViewModel_all.allServiceObserver().observe(this, all -> {

            if(all != null){
                activityMainBinding.setAll(all);
                activityMainBinding.progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }


    @Override
    public void detailedInfo() {
        Intent countryIntent = new Intent(this, CountryListActivity.class);
        startActivity(countryIntent);

    }
}
