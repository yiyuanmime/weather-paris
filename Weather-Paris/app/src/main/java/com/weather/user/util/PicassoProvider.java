package com.weather.user.util;

import android.content.Context;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by yi on 16/07/2017.
 */

public class PicassoProvider {

    private static Picasso instance;

    public static Picasso getInstance(final Context context) {

        if (instance == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request original = chain.request();

                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Cache-Control", "max-age=86400")//One day
                                .method(original.method(), original.body());

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    });


            final Downloader okHttpDownloader = new OkHttp3Downloader(builder.build());
            instance = new Picasso.Builder(context).listener((picasso, uri, exception) -> Log.e("Picasso Error", "Errored out, hiding view " + uri)).downloader(okHttpDownloader).build();
        }
        return instance;
    }

    public static void setTestInstance(Picasso instance) {
        PicassoProvider.instance = instance;
    }


}
