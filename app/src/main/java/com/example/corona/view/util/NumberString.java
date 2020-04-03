package com.example.corona.view.util;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberString {

    public static String numberFormat(int number)
    {
        return NumberFormat.getInstance(Locale.US).format(number);
    }
}
