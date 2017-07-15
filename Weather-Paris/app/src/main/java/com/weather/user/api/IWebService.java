package com.weather.user.api;

import com.weather.user.api.request.WeatherRequest;
import com.weather.user.mvp.WeatherView;

/**
 * Created by yi on 14/07/2017.
 */

public interface IWebService {

    void getWeather(WeatherView weatherView, WeatherRequest request);

}
