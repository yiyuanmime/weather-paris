package com.weather.user.model;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yi on 14/07/2017.
 */

@Getter
@Setter
public class WWeather implements Parcelable {

    public Integer id;
    public String main;
    public String description;
    public String icon;

    public final static Parcelable.Creator<WWeather> CREATOR = new Creator<WWeather>() {

        @SuppressWarnings({
                "unchecked"
        })
        public WWeather createFromParcel(Parcel in) {
            WWeather instance = new WWeather();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.main = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.icon = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public WWeather[] newArray(int size) {
            return (new WWeather[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(main);
        dest.writeValue(description);
        dest.writeValue(icon);
    }

    public int describeContents() {
        return 0;
    }

}