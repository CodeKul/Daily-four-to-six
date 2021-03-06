package com.melayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {


    private int id;
    private MediaPlayer player;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.id = startId;
        new Thread(new Runnable() {
            @Override
            public void run() {
                player = MediaPlayer.create(MyService.this, R.raw.my);
                player.start();
            }
        }).start();

        return START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onDestroy() {

        player.stop();
        player.release();
        super.onDestroy();
    }
}
