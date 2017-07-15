package com.weather.user.api.task;

import com.weather.user.BuildConfig;
import com.weather.user.api.ServiceApi;
import com.weather.user.api.request.WeatherRequest;
import com.weather.user.api.response.WeatherResponse;
import com.weather.user.mvp.WeatherView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by yi on 14/07/2017.
 */

public class GetWeatherTask {
    private Retrofit r;
    private WeatherView weatherView;
    private WeatherRequest request;

    public GetWeatherTask(Retrofit r, WeatherView weatherView, WeatherRequest request) {
        this.r = r;
        this.weatherView = weatherView;
        this.request = request;
    }

    public void doTask() {

        final ServiceApi serverApi = r.create(ServiceApi.class);
        serverApi.getWeatherList(request.getCity(), request.getUnits(), request.getCnt(), BuildConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subject<Response<WeatherResponse>>() {
                    @Override
                    public boolean hasObservers() {
                        return false;
                    }

                    @Override
                    public boolean hasThrowable() {
                        return false;
                    }

                    @Override
                    public boolean hasComplete() {
                        return false;
                    }

                    @Override
                    public Throwable getThrowable() {
                        return null;
                    }

                    @Override
                    protected void subscribeActual(Observer<? super Response<WeatherResponse>> observer) {

                    }

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Response<WeatherResponse> weatherResponseResponse) {
                        if (weatherResponseResponse != null && weatherResponseResponse.isSuccessful() && weatherResponseResponse.body() != null)
                            weatherView.onGetWeatherSuccess(weatherResponseResponse.body());
                        else
                            weatherView.onError();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        weatherView.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
