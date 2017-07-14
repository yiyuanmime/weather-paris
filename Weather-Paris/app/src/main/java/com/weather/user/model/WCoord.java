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
public class WCoord implements Parcelable {

    public Double lon;
    public Double lat;
    public final static Parcelable.Creator<WCoord> CREATOR = new Creator<WCoord>() {

        @SuppressWarnings({
                "unchecked"
        })
        public WCoord createFromParcel(Parcel in) {
            WCoord instance = new WCoord();
            instance.lon = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            return instance;
        }

        public WCoord[] newArray(int size) {
            return (new WCoord[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lon);
        dest.writeValue(lat);
    }

    public int describeContents() {
        return 0;
    }

}