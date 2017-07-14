package com.weather.user.api;

import com.weather.user.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yi on 14/07/2017.
 */

public class WebServiceImpl implements IWebService {

    private static final int DEFAULT_TIMEOUT = 30;
    private Retrofit baseAdapter;

    public Retrofit getBaseAdapter() {

        if (baseAdapter == null) {

            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .addInterceptor(logInterceptor);

            baseAdapter = new Retrofit.Builder()
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BuildConfig.REST_SERVER_URL)
                    .build();

        }

        return baseAdapter;
    }


}
