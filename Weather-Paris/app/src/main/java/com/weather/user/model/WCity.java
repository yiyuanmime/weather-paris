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
public class WCity implements Parcelable {

    public Integer id;
    public String name;
    public WCoord WCoord;
    public String country;
    public Integer population;
    public final static Parcelable.Creator<WCity> CREATOR = new Creator<WCity>() {

        @SuppressWarnings({
                "unchecked"
        })
        public WCity createFromParcel(Parcel in) {
            WCity instance = new WCity();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.WCoord = ((WCoord) in.readValue((WCoord.class.getClassLoader())));
            instance.country = ((String) in.readValue((String.class.getClassLoader())));
            instance.population = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public WCity[] newArray(int size) {
            return (new WCity[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(WCoord);
        dest.writeValue(country);
        dest.writeValue(population);
    }

    public int describeContents() {
        return 0;
    }


}
