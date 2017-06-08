package com.codekul.viewanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAnimate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        findViewById(R.id.imageView).startAnimation(animation);
    }
}
