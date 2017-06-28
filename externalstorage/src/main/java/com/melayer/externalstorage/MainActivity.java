package com.melayer.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

    private Boolean isMedia() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public void writePrivate(View view) {
        if(isMedia()) {

            File file = new File(getExternalFilesDir(""), "my.txt");
            Log.i("@codekul", "External Path - "+file.getAbsolutePath());
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("welcome to codekul".getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "Media Not Available", Toast.LENGTH_SHORT).show();
        }
    }

    public void readPrivate(View view) {
        if(isMedia()) {
            File file = new File(getExternalFilesDir(""), "my.txt");
            Log.i("@codekul", "External Path - "+file.getAbsolutePath());
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder builder = new StringBuilder();
                while(true) {
                    int ch = fis.read();
                    if(ch == -1) break;
                    else builder.append((char)ch);
                }
                Log.i("@codekul", "Private Data "+builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            Toast.makeText(this, "Media Not Available", Toast.LENGTH_SHORT).show();
        }
    }

    public void writePublic(View view) {
        if(isMedia()) {

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "my.txt");
            Log.i("@codekul", "Public External Path - "+file.getAbsolutePath());

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("welcome to codekul".getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "Media Not Available", Toast.LENGTH_SHORT).show();
        }
    }

    public void readPublic(View view) {
        if(isMedia()) {

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "my.txt");
            Log.i("@codekul", "public External Path - "+file.getAbsolutePath());
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder builder = new StringBuilder();
                while(true) {
                    int ch = fis.read();
                    if(ch == -1) break;
                    else builder.append((char)ch);
                }
                Log.i("@codekul", "Public Data "+builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            File demo = Environment.getExternalStoragePublicDirectory("");
            for(File f : demo.listFiles()) {
                Log.i("@codekul", ""+(f.isDirectory() ? " - " : " * ")+" "+f.getName());
            }
        }else {
            Toast.makeText(this, "Media Not Available", Toast.LENGTH_SHORT).show();
        }
    }
}
