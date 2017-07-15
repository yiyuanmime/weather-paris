package com.weather.user.api;

import com.weather.user.BuildConfig;
import com.weather.user.api.request.WeatherRequest;
import com.weather.user.api.task.GetWeatherTask;
import com.weather.user.mvp.WeatherView;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BuildConfig.REST_SERVER_URL)
                    .build();

        }

        return baseAdapter;
    }

    @Override
    public void getWeather(WeatherView weatherView, WeatherRequest request) {
        GetWeatherTask getWeatherTask = new GetWeatherTask(getBaseAdapter(), weatherView, request);
        getWeatherTask.doTask();
    }
}
