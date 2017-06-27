package com.melayer.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onWrite(View view) {

        try {
            FileOutputStream fos = openFileOutput("my.txt", MODE_APPEND);
            fos.write("Welcome to codekul".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onRead(View view) {
        try {
            FileInputStream fis = openFileInput("my.txt");
            StringBuilder builder = new StringBuilder();
            while(true) {
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

            Log.i("@codekul", "Data From File - "+builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Log.i("@codekul", "Path - "+getFilesDir().getAbsolutePath());

        String []names = fileList();
        for(String name : names) {
            Log.i("@codekul", "Name - "+name);
        }
    }
}
