package com.example.corona.view.util;

import android.annotation.SuppressLint;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NumberString {


    public static String numberFormat(long number)
    {
        return NumberFormat.getInstance(Locale.US).format(number);
    }

    public static String DateFormat(long UpdateTime){

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        return new Date(UpdateTime).toString();

    }
}
