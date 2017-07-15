package com.weather.user.api;

import com.weather.user.api.response.WeatherResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

/**
 * Created by yi on 14/07/2017.
 */

public interface ServiceApi {

    @GET("data/2.5/forecast/daily")
    Observable<Response<WeatherResponse>> getWeatherList(@Query("q") String q,
                                                         @Query("units") String units,
                                                         @Query("cnt") Integer cnt,
                                                         @Query("appid") String appid);

}
