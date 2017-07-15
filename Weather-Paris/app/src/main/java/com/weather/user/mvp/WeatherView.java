package com.weather.user.mvp;

import com.weather.user.api.response.WeatherResponse;

/**
 * Created by yi on 15/07/2017.
 */

public interface WeatherView {

    void onGetWeatherSuccess(WeatherResponse weatherResponse);

    void onError();

}
