package com.example.corona.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

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

        serviceViewModel_all = ViewModelProviders.of(this).get(CoronaServiceViewModel_All.class);


        Objects.requireNonNull(getSupportActionBar()).hide();

        observeViewModel(serviceViewModel_all);
        activityMainBinding.setIMainActivityCallBack(this);

    }


    private void observeViewModel(CoronaServiceViewModel_All serviceViewModel_all) {
        serviceViewModel_all.allServiceObserver().observe(this, all -> {

            if(all != null){
                all.setActiveCases(all.getCases() - all.getDeaths() - all.getRecovered());
                activityMainBinding.setAll(all);
            }
        });
    }


    @Override
    public void detailedInfo() {
        Intent countryIntent = new Intent(this, CountryListActivity.class);
        startActivity(countryIntent);

    }
}
