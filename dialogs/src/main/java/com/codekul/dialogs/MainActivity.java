package com.codekul.dialogs;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAlert(View view) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes", null)
                .setNegativeButton("No", null)
                .setNeutralButton("Okay", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onDate(View view) {

    }

    public void onTime(View view) {

    }

    public void onProgres(View view) {

    }

    public void onCustom(View view) {

    }
}
