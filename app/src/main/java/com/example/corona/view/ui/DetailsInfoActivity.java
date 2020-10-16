package com.example.corona.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.corona.R;
import com.example.corona.databinding.ActivityDetailsInfoBinding;
import com.example.corona.viewmodel.CoronaServiceViewModel_DetailsInfo;

public class DetailsInfoActivity extends AppCompatActivity {

    ActivityDetailsInfoBinding detailsInfoBinding;
    CoronaServiceViewModel_DetailsInfo model_detailsInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailsInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_info);
        model_detailsInfo = new ViewModelProvider(this).get(CoronaServiceViewModel_DetailsInfo.class);

        detailsInfoBinding.progressBar.setVisibility(View.VISIBLE);

        String Country = getIntent().getStringExtra("country");

        getSupportActionBar().setTitle("Corona Updates");
        observeViewModel(model_detailsInfo, Country);
        
    }

    private void observeViewModel(CoronaServiceViewModel_DetailsInfo model_detailsInfo, String country) {
        model_detailsInfo.getDetailedInfo(country).observe(this, countryList -> {
            if(countryList  != null){
                detailsInfoBinding.setDetail(countryList);
                detailsInfoBinding.progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
