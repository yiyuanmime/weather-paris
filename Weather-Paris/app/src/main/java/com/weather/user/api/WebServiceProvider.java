package com.weather.user.api;

/**
 * Created by yi on 14/07/2017.
 */

public class WebServiceProvider {

    private static IWebService instance;

    public static IWebService getInstance() {

        if (instance == null)
            instance = new WebServiceImpl();

        return instance;
    }

}
