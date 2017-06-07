package com.codekul.interactivitycomm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtGmail = (EditText) findViewById(R.id.etGmail);

                Bundle bundle = new Bundle();
                bundle.putString("gmail", edtGmail.getText().toString());

                Context context = MainActivity.this;
                Class cls = NextActivity.class;
                Intent intent = new Intent(context, cls);
                intent.putExtras(bundle);

                //startActivity(intent);

                startActivityForResult(intent, 1234);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1234) {
            if(resultCode == RESULT_OK) {

                Bundle bundle = data.getExtras();
                String ymail = bundle.getString("ymail");

                ((EditText)findViewById(R.id.etYmail)).setText(ymail);
            }
        }
    }
}
