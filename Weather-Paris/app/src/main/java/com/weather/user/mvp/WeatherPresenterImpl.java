package com.weather.user.mvp;

import com.weather.user.api.WebServiceProvider;
import com.weather.user.api.request.WeatherRequest;

/**
 * Created by yi on 15/07/2017.
 */

public class WeatherPresenterImpl implements WeatherPresenter {

    private WeatherView weatherView;

    public WeatherPresenterImpl(WeatherView weatherView) {
        this.weatherView = weatherView;
    }

    @Override
    public void getWeatherForDays(int days) {

        WeatherRequest request = new WeatherRequest();
        request.setCity("Paris");
        request.setUnits("metric");
        request.setCnt(days);

        WebServiceProvider.getInstance().getWeather(weatherView, request );

    }
}
