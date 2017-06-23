package com.codekul.uithread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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
        new MyTask(
                (TextView) findViewById(R.id.txtCnts)
        ).execute(0, 100);
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

    private class MyTask extends AsyncTask<Integer/*Params*/, Integer, Boolean/*Result*/> {

        private TextView textCntr;
        private ProgressDialog pd;

        MyTask(TextView textCntr) {
            this.textCntr = textCntr;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // UI thread

            pd = ProgressDialog.show(MainActivity.this, "Title", "Message");
        }

        @Override
        protected Boolean doInBackground(Integer... integers/*Params*/) {

            // worker thread

            for (int i = integers[0]; i < integers[1]; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean/*result*/) {
            super.onPostExecute(aBoolean);

            //ui thread

            pd.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // ui thread
            textCntr.setText(String.valueOf(values[0]));
        }
    }
}
