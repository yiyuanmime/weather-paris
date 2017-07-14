package com.weather.user;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by yi on 14/07/2017.
 */

public class WeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        sResources = this.getResources();
        sContext = getApplicationContext();

    }

    private static Resources sResources;
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    public static Resources BaseResources() {
        return sResources;
    }

}
