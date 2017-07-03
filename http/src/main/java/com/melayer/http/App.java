package com.melayer.http;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by aniruddha on 3/7/17.
 */

public class App extends Application {

    private RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(this);
    }

    public RequestQueue q() {
        return queue;
    }
}
