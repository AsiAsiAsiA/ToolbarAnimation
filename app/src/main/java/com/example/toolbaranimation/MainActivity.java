package com.example.toolbaranimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MotionLayout motion_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        motion_container= findViewById(R.id.motion_container);
    }

    public void start(View view) {
        motion_container.transitionToEnd();
    }
}
