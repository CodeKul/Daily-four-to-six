package com.codekul.uithread;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 1. handlers
    // 2. Async Task
    // 3. Observables

    private int i = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.getMainLooper());
    }

    public void onOkay(View view) {
        onThread();
    }


    private void simple() {
        final TextView txtCntr = (TextView) findViewById(R.id.txtCnts);
        for (i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //txtCntr.setText("" + i);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    txtCntr.setText("" + i);
                }
            });
        }
    }

    private void onThread() {

        // worker thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                simple();
            }
        }).start();
    }
}
