package com.codekul.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean isNumOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> dataSet = new ArrayList<>();
        dataSet.add("1");
        dataSet.add("2");
        dataSet.add("3");
        dataSet.add("4");
        dataSet.add("5");
        dataSet.add("6");
        dataSet.add("7");
        dataSet.add("8");
        dataSet.add("9");
        dataSet.add("0");
        dataSet.add("+");
        dataSet.add("-");
        dataSet.add("/");
        dataSet.add("*");
        dataSet.add("=");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);

        ((GridView)findViewById(R.id.gridView)).setAdapter(adapter);
        ((GridView)findViewById(R.id.gridView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(isNumOne) {
                    String num = ((TextView)findViewById(R.id.etNm1)).getText() + adapter.getItem(position);
                    ((TextView)findViewById(R.id.etNm1)).setText(num);
                }
                else {
                    String num = ((TextView)findViewById(R.id.etNm2)).getText() + adapter.getItem(position);
                    ((TextView)findViewById(R.id.etNm2)).setText(num);
                }
            }
        });

        findViewById(R.id.etNm1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNumOne = true;
            }
        });

        findViewById(R.id.etNm2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNumOne = false;
            }
        });
    }
}
