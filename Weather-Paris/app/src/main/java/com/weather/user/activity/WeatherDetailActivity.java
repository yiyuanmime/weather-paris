package com.weather.user.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.weather.user.R;
import com.weather.user.model.WList;
import com.weather.user.mvp.WeatherDetailPresenter;
import com.weather.user.mvp.WeatherDetailPresenterImpl;
import com.weather.user.mvp.WeatherDetailView;
import com.weather.user.util.PicassoProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yi on 16/07/2017.
 */

public class WeatherDetailActivity extends AppCompatActivity implements WeatherDetailView {

    public final static String DETAIL_TAG = "DETAIL_TAG";

    @BindView(R.id.conditionIcon)
    ImageView conditionIcon;

    @BindView(R.id.humidity)
    TextView humidity;

    @BindView(R.id.pressure)
    TextView pressure;

    @BindView(R.id.tmax)
    TextView tmax;

    @BindView(R.id.tmin)
    TextView tmin;

    @BindView(R.id.wind)
    TextView wind;

    private WeatherDetailPresenter weatherDetailPresenter;

    private WList wList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_detail_activity);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getString(R.string.weather_label_detail));

        wList = (WList) getIntent().getParcelableExtra(DETAIL_TAG);

        initPresenter();

    }

    private void initPresenter() {
        weatherDetailPresenter = new WeatherDetailPresenterImpl(this);
        if (wList != null)
            weatherDetailPresenter.processWeatherDetail(wList);
    }

    @Override
    public void setWeatherDetail(String icon, String humidity, String pressure, String tMax, String tMin, String wind) {
        if (!TextUtils.isEmpty(icon))
            PicassoProvider.getInstance(conditionIcon.getContext()).load(icon).fit().into(conditionIcon);

        if (!TextUtils.isEmpty(humidity))
            this.humidity.setText(humidity);

        if (!TextUtils.isEmpty(pressure))
            this.pressure.setText(pressure);

        if (!TextUtils.isEmpty(tMax))
            this.tmax.setText(tMax);

        if (!TextUtils.isEmpty(tMin))
            this.tmin.setText(tMin);

        if (!TextUtils.isEmpty(wind))
            this.wind.setText(wind);

    }

    @Override
    public void onError() {

    }
}
