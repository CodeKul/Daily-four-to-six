package com.melayer.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);
    }

    public void onBtnStart(View view) {
        startService(intent);
    }

    public void onBtnStop(View view) {
        stopService(intent);
    }
}
