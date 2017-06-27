package com.melayer.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        prefs = getPreferences(MODE_APPEND);

        prefs = getSharedPreferences("my_prefs", MODE_APPEND);
    }

    public void onWrite(View view) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat("keyFloat", 45.36f);
        editor.putInt("keyInt", 45);
        editor.putBoolean("keyBoolean", true);
        editor.apply();

        Log.i("@codekul", "Data Written");
    }

    public void onRead(View view)  {

        float _float = prefs.getFloat("keyFloat", -96);
        int _int = prefs.getInt("keyInt", -6);
        Boolean _boolean = prefs.getBoolean("keyBoolean", false);

        Log.i("@codekul", "Float - "+ _float +" Int - "+ _int +" Boolean - "+_boolean);
    }
}
