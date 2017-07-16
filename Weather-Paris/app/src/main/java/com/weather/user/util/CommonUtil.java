package com.weather.user.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yi on 16/07/2017.
 */

public class CommonUtil {


    public static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }


    public static String formatDate(Long timestamp){

        Date date = new Date(timestamp);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String s = df.format(date);

        return s;
    }
}
