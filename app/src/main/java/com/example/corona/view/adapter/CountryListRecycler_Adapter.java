package com.example.corona.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.R;
import com.example.corona.databinding.ItemCountryListBinding;
import com.example.corona.services.model.CountryList;
import com.example.corona.view.callback.ICountryListRecycler;

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

        final ItemCountryListBinding itemCountryListBinding = holder.getItemCountryListBinding();
        itemCountryListBinding.setAdapter(new ICountryListRecycler() {
            @Override
            public void onItemClick() {
                Log.e("Ok", "" + countryLists.get(position).getCountry());
            }
        });
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


        public ItemCountryListBinding getItemCountryListBinding(){
            return itemCountryListBinding;
        }
    }


}
