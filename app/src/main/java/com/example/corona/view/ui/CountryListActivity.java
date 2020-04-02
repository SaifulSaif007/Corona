package com.example.corona.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.corona.R;
import com.example.corona.databinding.ActivityCountryListBinding;
import com.example.corona.services.model.CountryList;
import com.example.corona.view.adapter.CountryListRecycler_Adapter;
import com.example.corona.viewmodel.CoronaServiceViewModel_CountryList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CountryListActivity extends AppCompatActivity implements CountryListRecycler_Adapter.itemClickListner{

    ActivityCountryListBinding countryListBinding;
    CoronaServiceViewModel_CountryList coronaServiceViewModel_countryList;
    private CountryListRecycler_Adapter countryListRecyclerAdapter;
    private List<CountryList> countryLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        countryListBinding = DataBindingUtil.setContentView(this, R.layout.activity_country_list);

        coronaServiceViewModel_countryList = ViewModelProviders.of(this).get(CoronaServiceViewModel_CountryList.class);

        ObserveViewModel(coronaServiceViewModel_countryList);
        initRecycler();
    }


    private void initRecycler() {

        countryLists = new ArrayList<>();

        countryListRecyclerAdapter = new CountryListRecycler_Adapter(countryLists, this);

        int numColumns = 1;

        GridLayoutManager gridLayoutManager;

        gridLayoutManager = new GridLayoutManager(getApplicationContext(), numColumns);

        countryListBinding.mCountrylistRecycler.setLayoutManager(gridLayoutManager);

        countryListBinding.mCountrylistRecycler.setHasFixedSize(true);

        countryListBinding.mCountrylistRecycler.setAdapter(countryListRecyclerAdapter);
    }


    private void ObserveViewModel(CoronaServiceViewModel_CountryList coronaServiceViewModel_countryList) {
        coronaServiceViewModel_countryList.getCountryList().observe(this, countryList -> {

            if(countryList != null){

                countryLists.addAll(countryList);
                Collections.reverse(countryLists);

                countryListRecyclerAdapter.SetAllList(countryList);

                countryListRecyclerAdapter.notifyDataSetChanged();

            }
        });
    }


    @Override
    public void onItemClick(int position) {

        Intent detaitlsIntent = new Intent(this, DetailsInfoActivity.class);
        detaitlsIntent.putExtra("country", countryLists.get(position).getCountry()) ;
        startActivity(detaitlsIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.country_search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_menu);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                countryListRecyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
