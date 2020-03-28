package com.example.corona.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.R;
import com.example.corona.databinding.ItemCountryListBinding;
import com.example.corona.services.model.CountryList;

import java.util.List;

public class CountryListRecycler_Adapter extends RecyclerView.Adapter<CountryListRecycler_Adapter.RecycleViewHolder> {

    private List<CountryList> countryLists;

    public CountryListRecycler_Adapter(List<CountryList> countryLists) {
        this.countryLists = countryLists;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemCountryListBinding itemCountryListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_country_list, parent, false);

        return new RecycleViewHolder(itemCountryListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {

        holder.itemCountryListBinding.setCountryLists(countryLists.get(position));
    }

    @Override
    public int getItemCount() {
        return countryLists.size();
    }


    static class RecycleViewHolder extends RecyclerView.ViewHolder{

        ItemCountryListBinding itemCountryListBinding;

        RecycleViewHolder(@NonNull ItemCountryListBinding itemView) {
            super(itemView.getRoot());

            itemCountryListBinding = itemView;
        }
    }
}
