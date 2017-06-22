package com.codekul.statusbarnotifications;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent resIn = getIntent();
        Bundle bundle = resIn.getExtras();
        if(bundle != null) {
            ((TextView)findViewById(R.id.txtInfo)).setText(bundle.getString("nm"));
        }
    }
}
