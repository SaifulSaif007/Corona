package com.example.corona.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.corona.R;
import com.example.corona.databinding.ActivityCountryListBinding;
import com.example.corona.viewmodel.CoronaServiceViewModel_CountryList;

import java.util.Objects;

public class CountryListActivity extends AppCompatActivity {

    ActivityCountryListBinding countryListBinding;
    CoronaServiceViewModel_CountryList coronaServiceViewModel_countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        Objects.requireNonNull(getSupportActionBar()).hide();

        countryListBinding = DataBindingUtil.setContentView(this, R.layout.activity_country_list);

        coronaServiceViewModel_countryList = ViewModelProviders.of(this).get(CoronaServiceViewModel_CountryList.class);

        ObserveViewModel(coronaServiceViewModel_countryList);
    }


    private void ObserveViewModel(CoronaServiceViewModel_CountryList coronaServiceViewModel_countryList) {
        coronaServiceViewModel_countryList.getCountryList().observe(this, countryList -> {

            if(countryList != null){
                countryListBinding.setCountyList(countryList.get(0));
                Log.e("country", "" + countryList.get(0).toString());
            }
        });
    }
}
