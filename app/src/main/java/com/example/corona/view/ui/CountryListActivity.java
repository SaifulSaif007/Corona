package com.example.corona.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.corona.R;
import com.example.corona.databinding.ActivityCountryListBinding;
import com.example.corona.services.model.CountryList;
import com.example.corona.view.adapter.CountryListRecycler_Adapter;
import com.example.corona.view.callback.ICountryListRecycler;
import com.example.corona.viewmodel.CoronaServiceViewModel_CountryList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CountryListActivity extends AppCompatActivity{

    ActivityCountryListBinding countryListBinding;
    CoronaServiceViewModel_CountryList coronaServiceViewModel_countryList;
    private CountryListRecycler_Adapter countryListRecyclerAdapter;
    private List<CountryList> countryLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        Objects.requireNonNull(getSupportActionBar()).hide();

        countryListBinding = DataBindingUtil.setContentView(this, R.layout.activity_country_list);


        coronaServiceViewModel_countryList = ViewModelProviders.of(this).get(CoronaServiceViewModel_CountryList.class);

        ObserveViewModel(coronaServiceViewModel_countryList);
        initRecycler();
    }


    private void initRecycler() {

        countryLists = new ArrayList<>();

        countryListRecyclerAdapter = new CountryListRecycler_Adapter(countryLists);

        int numColumns = 1;

        GridLayoutManager gridLayoutManager;

        gridLayoutManager = new GridLayoutManager(getApplicationContext(), numColumns);

        countryListBinding.mCountrylistRecycler.setLayoutManager(gridLayoutManager);

        countryListBinding.mCountrylistRecycler.addItemDecoration(new DividerItemDecoration(getApplicationContext(), 1));

        countryListBinding.mCountrylistRecycler.setHasFixedSize(true);

        countryListBinding.mCountrylistRecycler.setAdapter(countryListRecyclerAdapter);
    }


    private void ObserveViewModel(CoronaServiceViewModel_CountryList coronaServiceViewModel_countryList) {
        coronaServiceViewModel_countryList.getCountryList().observe(this, countryList -> {

            if(countryList != null){

                countryLists.addAll(countryList);
                Collections.reverse(countryLists);

                countryListRecyclerAdapter.notifyDataSetChanged();

            }
        });
    }


}
