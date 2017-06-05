package com.codekul.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener clicked = new Click();
        clicked = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };

        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        //btnLogin.setOnClickListener(new Click());
        //btnLogin.setOnClickListener(clicked);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText etUserName = (EditText) findViewById(R.id.etUserName);

                EditText etPassword = (EditText) findViewById(R.id.etPassword);

                TextView textView = (TextView) findViewById(R.id.txtInfo);

                if(etUserName.getText().toString().equals("codekul")
                        && etPassword.getText().toString().equals("codekul")) {
                    textView.setText(":)");
                }
                else textView.setText(":(");
            }
        });
    }

    private class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
