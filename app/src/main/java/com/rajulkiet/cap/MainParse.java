package com.rajulkiet.cap;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Aditya on 6/14/2017.
 */

public class MainParse extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
        .applicationId("8PfCuzJDi0ghAyD2zdo5ThvSqtlkduoXHQIq84S3")
        .clientKey("vFuFQbFRaSI8N1JY8VtPPkkmGPb1fSnP4z6iq2az")
        .server("https://parseapi.back4app.com/")
        .build()
        );
    }
}
