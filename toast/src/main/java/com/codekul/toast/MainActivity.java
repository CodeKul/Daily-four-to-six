package com.codekul.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOkay(View view) {
//        Toast.makeText(this, "This is Toast", Toast.LENGTH_SHORT).show();

        customToast();
    }

    private void customToast() {
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_LONG);
        Button btn = new Button(this);
        btn.setText("Okay");
        toast.setView(btn);
        toast.show();
    }
}
