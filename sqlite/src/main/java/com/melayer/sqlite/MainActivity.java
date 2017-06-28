package com.melayer.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DbHelper(
                this,
                "myDb.sqlite",
                null,
                1
        );
    }

    public void onInsert(View view) {

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("myName", ((EditText) findViewById(R.id.etName)).getText().toString());
        values.put("myBike", ((EditText) findViewById(R.id.etBike)).getText().toString());
        values.put("siz", ((EditText) findViewById(R.id.etSize)).getText().toString());

        if (sqDb.insert(
                "myTab",
                null,
                values
        ) != -1) {
            Log.i("@codekul", "Row inserted successfully");
        } else {
            Log.i("@codekul", "Problem in data insertion");
        }
        sqDb.close();
    }

    public void onUpdate(View view) {
        SQLiteDatabase sqDb = helper.getWritableDatabase();

        String table = "myTab";
        ContentValues values = new ContentValues();
        values.put("myName", ((EditText) findViewById(R.id.etName)).getText().toString());
        values.put("myBike", ((EditText) findViewById(R.id.etBike)).getText().toString());

        String whereClause = "siz = ?";
        String[] whereArgs = {((EditText) findViewById(R.id.etSize)).getText().toString()};

        sqDb.update(table, values, whereClause, whereArgs);
        sqDb.close();
    }

    public void onDelete(View view) {
        SQLiteDatabase sqDb = helper.getWritableDatabase();
        String table = "myTab";
        String whereClause = "siz = ?";
        String[] whereArgs = {((EditText) findViewById(R.id.etSize)).getText().toString()};

        sqDb.delete(table, whereClause, whereArgs);

        sqDb.close();
    }

    public void onQuery(View view) {
        selectAll();
    }

    public void onRaw(View view) {

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        Cursor cursor = sqDb.rawQuery(" select * from myTab where siz = ? ", new String[]{((EditText) findViewById(R.id.etSize)).getText().toString()});

        while (cursor.moveToNext()) {

            String myName = cursor.getString(0);
            String myBike = cursor.getString(1);
            int siz = cursor.getInt(cursor.getColumnIndex("siz"));

            Log.i("@codekul", " Name - " + myName + " Bike - " + myBike + " Size - " + siz);
        }

        cursor.close();
        sqDb.close();
    }

    private void selectFew() {

        SQLiteDatabase sqDb = helper.getReadableDatabase();

        String table = "myTab";
        String[] columns = {"myName", "myBike"};
        String selection = "siz = ?";
        String[] selectionArgs = {((EditText) findViewById(R.id.etSize)).getText().toString()};
        String groupBy = "";
        String having = "";
        String orderBy = "";

        Cursor cursor = sqDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()) {

            String myName = cursor.getString(cursor.getColumnIndex("myName"));
            String myBike = cursor.getString(cursor.getColumnIndex("myBike"));

            Log.i("@codekul", " Name - " + myName + " Bike - " + myBike);
        }

        cursor.close();
        sqDb.close();

    }

    private void selectAll() {
        SQLiteDatabase sqDb = helper.getReadableDatabase();

        String table = "myTab";
        String[] columns = {};
        String selection = "";
        String[] selectionArgs = {};
        String groupBy = "";
        String having = "";
        String orderBy = "";

        Cursor cursor = sqDb.query(
                table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy
        );

        while (cursor.moveToNext()) {

            String myName = cursor.getString(0);
            String myBike = cursor.getString(1);
            int siz = cursor.getInt(cursor.getColumnIndex("siz"));

            Log.i("@codekul", " Name - " + myName + " Bike - " + myBike + " Size - " + siz);
        }

        cursor.close();
        sqDb.close();
    }
}
