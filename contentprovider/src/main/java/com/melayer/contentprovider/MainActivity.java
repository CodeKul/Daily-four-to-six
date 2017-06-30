package com.melayer.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readMyData();
    }

    private void readContacts() {

        List<String> dataSet = new ArrayList<>();
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                },
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            dataSet.add(name + " \n " + num);
        }

        ((ListView) findViewById(R.id.listView)).setAdapter(new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        dataSet
                )
        );
        cursor.close();
    }

    private void readMyData() {

        List<String> dataSet = new ArrayList<>();
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                Uri.parse("content://com.codekul.custom.provider"),
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            String bike = cursor.getString(cursor.getColumnIndex("myBike"));
            String name = cursor.getString(cursor.getColumnIndex("myName"));
            int siz = cursor.getInt(cursor.getColumnIndex("siz"));

            dataSet.add(bike +"\n"+name +"\n"+siz);
        }

        ((ListView) findViewById(R.id.listView)).setAdapter(new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        dataSet
                )
        );
        cursor.close();
    }
}
