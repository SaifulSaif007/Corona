package com.example.corona.services.repository;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.corona.services.Context.GlobalApplication;

import java.io.EOFException;
import java.io.File;
import java.util.Objects;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    @SuppressLint("StaticFieldLeak")
    static Context context = GlobalApplication.getAppContext();
    static File HttpCacheDirectory = new File(Objects.requireNonNull(context).getCacheDir() , "httpCache");
    static Cache cache  = new Cache(HttpCacheDirectory, 10*1021*1024);

    private static final String BASE_URL = "https://corona.lmao.ninja/v3/covid-19/";

    static OkHttpClient httpClient = new OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(chain -> {
                try {
                    return chain.proceed(chain.request());
                } catch (Exception e) {
                    Request offlineRequest = chain.request().newBuilder()
                            .header("Cache-Control", "public, only-if-cached," +
                                    "max-stale=" + 60 * 60 * 24)
                            .build();
                    return chain.proceed(offlineRequest);
                }
            })
            .build();


    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(httpClient)
            .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
