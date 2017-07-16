package com.weather.user.bus.event;

import com.weather.user.model.WList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yi on 16/07/2017.
 */

@Getter
@Setter
public class WeatherEvent {

    public static enum WeatherEventType {
        WEATHER_DETAIL_CLICK
    }

    public WeatherEvent(WeatherEventType mEventType) {
        this.mEventType = mEventType;
    }

    private WeatherEvent.WeatherEventType mEventType;
    private WList wList;

}
