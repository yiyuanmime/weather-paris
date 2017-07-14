package com.weather.user.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.weather.user.model.WCity;
import com.weather.user.model.WList;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yi on 14/07/2017.
 */

@Getter
@Setter
public class WeatherResponse implements Parcelable {

    public WCity city;
    public String cod;
    public Double message;
    public Integer cnt;
    public List<WList> list = null;

    public final static Parcelable.Creator<WeatherResponse> CREATOR = new Creator<WeatherResponse>() {

        @SuppressWarnings({
                "unchecked"
        })
        public WeatherResponse createFromParcel(Parcel in) {
            WeatherResponse instance = new WeatherResponse();
            instance.city = ((WCity) in.readValue((WCity.class.getClassLoader())));
            instance.cod = ((String) in.readValue((String.class.getClassLoader())));
            instance.message = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.cnt = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.list = (ArrayList<WList>) in.readArrayList(WList.class.getClassLoader());
            return instance;
        }

        public WeatherResponse[] newArray(int size) {
            return (new WeatherResponse[size]);
        }

    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(city);
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
    }

    public int describeContents() {
        return 0;
    }

}
