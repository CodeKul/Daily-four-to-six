package com.codekul.simplevalueresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String hello = getResources().getString(R.string.hello);
        float little = getResources().getDimension(R.dimen.little);

        String[] os = getResources().getStringArray(R.array.os);

        int color = getResources().getColor(R.color.colorAccent);
        color = ContextCompat.getColor(this, R.color.colorAccent);
    }
}
