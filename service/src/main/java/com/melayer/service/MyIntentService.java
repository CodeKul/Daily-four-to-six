package com.melayer.service;

import android.app.IntentService;
import android.content.Intent;



public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
