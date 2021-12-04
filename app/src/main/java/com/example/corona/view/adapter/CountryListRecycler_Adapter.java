package com.example.corona.view.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.corona.R;
import com.example.corona.databinding.ItemCountryListBinding;
import com.example.corona.services.model.CountryList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CountryListRecycler_Adapter extends RecyclerView.Adapter<CountryListRecycler_Adapter.RecycleViewHolder> implements Filterable {

    private final List<CountryList> countryLists;
    private List<CountryList> countryListALL;
    private final itemClickListener listener;

    public CountryListRecycler_Adapter(List<CountryList> countryLists, itemClickListener clickListener) {
        this.countryLists = countryLists;
        this.listener = clickListener;
    }

    public void SetAllList(List<CountryList> countryListA){
        this.countryListALL = new ArrayList<>(countryListA);
        Collections.reverse(countryListALL);
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
        setAnimation(holder.itemView);

        itemCountryListBinding.setICountryCallBack(() -> listener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return countryLists.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }

    private final Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CountryList> filteredList = new ArrayList<>();

            if(constraint.toString().isEmpty()){
                filteredList.addAll(countryListALL);
            }
            else {
                for (int i=0; i< countryListALL.size(); i++){
                    if(countryListALL.get(i).getCountry().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(countryListALL.get(i));
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            countryLists.clear();
            countryLists.addAll((Collection<? extends CountryList>) results.values);
            notifyDataSetChanged();
        }
    };


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

    private void setAnimation(View viewToAnimate)
    {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
    }

    public interface itemClickListener {
        void onItemClick(int position);
    }
}
