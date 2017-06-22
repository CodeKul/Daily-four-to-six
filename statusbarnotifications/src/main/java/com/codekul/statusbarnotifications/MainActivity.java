package com.codekul.statusbarnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private static final int NOTIFICATION_SIMPLE = 1345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onOkay(View view) {

        Intent intent = new Intent(this, NotificationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("nm", "melayer - "+System.currentTimeMillis());
        intent.putExtras(bundle);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 7896, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("Ticker")
                .setContentText("Content Text")
                .setContentTitle("Content Title")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent)
                .addAction(R.mipmap.ic_launcher, "Download", pendingIntent)
                .addAction(R.mipmap.ic_launcher, "Cancel", pendingIntent);


        Notification notification = builder.build();
        manager.notify(NOTIFICATION_SIMPLE, notification);
    }
}
