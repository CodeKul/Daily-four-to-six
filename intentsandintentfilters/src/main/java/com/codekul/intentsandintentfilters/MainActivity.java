package com.codekul.intentsandintentfilters;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Every thing from intent should find the match

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOkay(View view) {
        //startActivity(new Intent(this, NewsActivity.class)); explicit intent

       url();
    }

    private void our() {
        Intent intent = new Intent();
        intent.setAction("com.codekul.action.WOW"); // implicit intent
        //intent.addCategory("com.codekul.category.WOW");
        intent.setData(Uri.parse("tel://45698"));
        startActivity(intent);
    }

    private void all() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN"); // implicit intent
        intent.addCategory("android.intent.category.LAUNCHER");
        startActivity(intent);
    }

    private void dial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        //intent.setData(Uri.parse("tel://9762548833"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    private void url() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://codekul.com"));
        startActivity(intent);
    }
}
