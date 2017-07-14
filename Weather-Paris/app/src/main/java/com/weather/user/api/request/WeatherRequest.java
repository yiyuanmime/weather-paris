package com.weather.user.api.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yi on 14/07/2017.
 */

@Getter
@Setter
public class WeatherRequest {

    private String city;
    private String units;
    private Integer cnt;

}
