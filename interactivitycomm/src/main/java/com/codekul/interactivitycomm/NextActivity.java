package com.codekul.interactivitycomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intentResponsible = getIntent();
        Bundle bundle = intentResponsible.getExtras();
        String gmail = bundle.getString("gmail");

        ((EditText) findViewById(R.id.etEmail)).setText(gmail);

        findViewById(R.id.btnChange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((EditText) findViewById(R.id.etEmail)).getText().toString();
                ((EditText) findViewById(R.id.etEmail)).setText(email.replace("gmail", "ymail"));
            }
        });
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ymail = ((EditText) findViewById(R.id.etEmail))
                        .getText().toString();

                Bundle bundleBack = new Bundle();
                bundleBack.putString("ymail", ymail);

                Intent intent = new Intent();
                intent.putExtras(bundleBack);

                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}
