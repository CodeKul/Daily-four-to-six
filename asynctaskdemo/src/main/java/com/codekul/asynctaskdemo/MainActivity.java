package com.codekul.asynctaskdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MyTask(
                (TextView) findViewById(R.id.textCnts)
        ).execute(0, 100);
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
