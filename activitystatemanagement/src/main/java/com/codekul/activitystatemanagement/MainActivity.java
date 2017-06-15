package com.codekul.activitystatemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_DT = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        if(savedInstanceState != null) {
            String date = savedInstanceState.getString(KEY_DT);
            ((TextView) findViewById(R.id.txtDt)).setText(date);
        }*/
        mt("onCreate");
    }

    public void onOkay(View view) {
        ((TextView) findViewById(R.id.txtDt)).setText(new Date().toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_DT, ((TextView) findViewById(R.id.txtDt)).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null) {
            String date = savedInstanceState.getString(KEY_DT);
            ((TextView) findViewById(R.id.txtDt)).setText(date);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mt("onDestroy");
    }

    private void mt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
