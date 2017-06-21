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
        appDialog(AppDialog.TAG_ALERT);
    }

    public void onDate(View view) {
        appDialog(AppDialog.TAG_DATE);
    }

    public void onTime(View view) {
        appDialog(AppDialog.TAG_TIME);
    }

    public void onProgress(View view) {
        appDialog(AppDialog.TAG_PROGRESS);
    }

    public void onCustom(View view) {
        appDialog(AppDialog.TAG_CUSTOM);
    }

    private void alert() {
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

    private void appDialog(String tag) {
        AppDialog dialog = new AppDialog();
        dialog.show(getSupportFragmentManager(), tag);
    }
}
