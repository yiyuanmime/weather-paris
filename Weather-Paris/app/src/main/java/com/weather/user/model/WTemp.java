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
public class WTemp implements Parcelable {

    public Double day;
    public Double min;
    public Double max;
    public Double night;
    public Double eve;
    public Double morn;
    public final static Parcelable.Creator<WTemp> CREATOR = new Creator<WTemp>() {

        @SuppressWarnings({
                "unchecked"
        })
        public WTemp createFromParcel(Parcel in) {
            WTemp instance = new WTemp();
            instance.day = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.min = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.max = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.night = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.eve = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.morn = ((Double) in.readValue((Double.class.getClassLoader())));
            return instance;
        }

        public WTemp[] newArray(int size) {
            return (new WTemp[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(day);
        dest.writeValue(min);
        dest.writeValue(max);
        dest.writeValue(night);
        dest.writeValue(eve);
        dest.writeValue(morn);
    }

    public int describeContents() {
        return 0;
    }

}