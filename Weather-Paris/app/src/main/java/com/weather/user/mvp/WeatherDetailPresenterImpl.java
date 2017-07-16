package com.weather.user.mvp;

import com.weather.user.model.WList;

/**
 * Created by yi on 16/07/2017.
 */

public class WeatherDetailPresenterImpl implements WeatherDetailPresenter {

    private WeatherDetailView weatherDetailView;

    public WeatherDetailPresenterImpl(WeatherDetailView weatherDetailView) {
        this.weatherDetailView = weatherDetailView;
    }

    @Override
    public void processWeatherDetail(WList wList) {

        String iconUrl = wList.getWeather().get(0) != null ? "http://openweathermap.org/img/w/" + wList.getWeather().get(0).icon + ".png" : null;
        String humidity = wList.getHumidity() != null ? String.valueOf(wList.getHumidity()) + "/100" : null;
        String pressure = wList.getPressure() != null ? String.valueOf(Math.round(wList.getPressure())) + " hPa" : null;
        String tmax = wList.getTemp().getMax() != null ? String.valueOf(Math.round(wList.getTemp().getMax())) + " degrees" : null;
        String tmin = wList.getTemp().getMin() != null ? String.valueOf(Math.round(wList.getTemp().getMin())) + " degrees" : null;
        String wind = wList.getSpeed() != null ? String.valueOf(Math.round(wList.getSpeed())) + " km/h" : null;

        weatherDetailView.setWeatherDetail(iconUrl, humidity, pressure, tmax, tmin, wind);

    }
}
