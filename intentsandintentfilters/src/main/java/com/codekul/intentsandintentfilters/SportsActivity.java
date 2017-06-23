package com.codekul.intentsandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SportsActivity extends AppCompatActivity {

    public static final String TAG = SportsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        Intent resIntent = getIntent();

        Uri uri = resIntent.getData();
        Log.i(TAG, "Scheme is "+resIntent.getScheme() + " Num is "+uri.getHost());
    }
}