package com.weather.user.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.weather.user.R;
import com.weather.user.api.response.WeatherResponse;
import com.weather.user.mvp.WeatherPresenter;
import com.weather.user.mvp.WeatherPresenterImpl;
import com.weather.user.mvp.WeatherView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yi on 14/07/2017.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherView{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    private WeatherPresenter weatherPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        initCollapsingToolbar();
        initPresenter();

    }

    private void initPresenter(){

        weatherPresenter = new WeatherPresenterImpl(this);
        weatherPresenter.getWeatherForDays(5);

    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void onGetWeatherSuccess(WeatherResponse weatherResponse) {

    }

    @Override
    public void onError() {

    }
}
