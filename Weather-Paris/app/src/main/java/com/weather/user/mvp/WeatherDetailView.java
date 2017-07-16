package com.weather.user.mvp;

/**
 * Created by yi on 16/07/2017.
 */

public interface WeatherDetailView {

    void setWeatherDetail(String icon, String humidity, String pressure, String tMax, String tMin, String wind);

    void onError();
}
