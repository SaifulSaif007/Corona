package com.example.corona.services.repository;

import android.content.Context;

import com.example.corona.services.Context.GlobalApplication;

import java.io.EOFException;
import java.io.File;
import java.util.Objects;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    static Context context = GlobalApplication.getAppContext();
    static File HttpCacheDirectory = new File(Objects.requireNonNull(context).getCacheDir() , "httpCache");
    static Cache cache  = new Cache(HttpCacheDirectory, 10*1021*1024);

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

    private static String BASE_URL = "https://corona.lmao.ninja/v2/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build();


    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
