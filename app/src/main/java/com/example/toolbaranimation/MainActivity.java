package com.example.toolbaranimation;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.core.widget.NestedScrollView;

public class MainActivity extends AppCompatActivity {
    MotionLayout motion_container;
    NestedScrollView nsv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);

        nsv = findViewById(R.id.nsv);
        iv = findViewById(R.id.iv);
        motion_container = findViewById(R.id.motion_container);
        motion_container.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {
                Log.i("Animation","Анимация начата");
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                if (i == R.id.ending_set) {
                    Log.i("Animation","Анимация завершена");
                    motion_container.setTransition(R.id.ending_set, R.id.set_3);
                    motion_container.setTransitionDuration(500);
                    motion_container.transitionToEnd();
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Animation","Клик");
                motion_container.transitionToEnd();
            }
        });
    }

    public void start(View view) {
        motion_container.transitionToEnd();
    }
}
