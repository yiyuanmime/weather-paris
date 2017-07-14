package com.weather.user.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yi on 14/07/2017.
 */
@Getter
@Setter
public class WList implements Parcelable {

    public Integer dt;
    public WTemp temp;
    public Double pressure;
    public Integer humidity;
    public List<WWeather> weather = null;
    public Double speed;
    public Integer deg;
    public Integer clouds;
    public final static Parcelable.Creator<WList> CREATOR = new Creator<WList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public WList createFromParcel(Parcel in) {
            WList instance = new WList();
            instance.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.temp = ((WTemp) in.readValue((WTemp.class.getClassLoader())));
            instance.pressure = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.humidity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.weather = (ArrayList<WWeather>) in.readArrayList(WWeather.class.getClassLoader());
            instance.speed = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.deg = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.clouds = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public WList[] newArray(int size) {
            return (new WList[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dt);
        dest.writeValue(temp);
        dest.writeValue(pressure);
        dest.writeValue(humidity);
        dest.writeList(weather);
        dest.writeValue(speed);
        dest.writeValue(deg);
        dest.writeValue(clouds);
    }

    public int describeContents() {
        return 0;
    }

}