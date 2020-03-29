package com.example.corona.databinding;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.corona.R;

public class GlideBindingAdapters {

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView view, String ImageUrl){
        Context context = view.getContext();

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.corona_logo1)
                .error(R.drawable.corona_logo1);

        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(ImageUrl)
                .into(view);

    }
}
