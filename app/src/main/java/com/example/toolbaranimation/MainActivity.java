package com.example.toolbaranimation;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;

public class MainActivity extends AppCompatActivity {
    MotionLayout motion_container;
    NestedScrollView nsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        motion_container = findViewById(R.id.motion_container);
//        nsv = findViewById(R.id.nsv);

        motion_container.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });
    }

    public void start(View view) {
        motion_container.transitionToEnd();
    }
}
