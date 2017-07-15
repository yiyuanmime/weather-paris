package com.weather.user.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.weather.user.R;
import com.weather.user.api.response.WeatherResponse;
import com.weather.user.mvp.WeatherPresenter;
import com.weather.user.mvp.WeatherPresenterImpl;
import com.weather.user.mvp.WeatherView;

import butterknife.ButterKnife;

/**
 * Created by yi on 14/07/2017.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherView{

    private WeatherPresenter weatherPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        ButterKnife.bind(this);

        initPresenter();

    }

    private void initPresenter(){

        weatherPresenter = new WeatherPresenterImpl(this);
        weatherPresenter.getWeatherForDays(5);

    }

    @Override
    public void onGetWeatherSuccess(WeatherResponse weatherResponse) {

    }

    @Override
    public void onError() {

    }
}
