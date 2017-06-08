package com.codekul.compoundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inflater = getLayoutInflater(); // if you are in activity

        //inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE); // if you have context

        inflater = LayoutInflater.from(this); // if you have context
    }

    public void onOkay(View view) {

        LinearLayout layoutParent = (LinearLayout) findViewById(R.id.layoutParent);
        View viewGen  = inflater.inflate(R.layout.compound_view, layoutParent, true);
    }
}
