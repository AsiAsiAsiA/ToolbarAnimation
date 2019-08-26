package com.example.toolbaranimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    View animateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        animateView = findViewById(R.id.animateView);
        btn.setOnClickListener(v -> onClick());
    }

    private void onClick() {
        int randowValue = new Random().nextInt(1000);
        Log.i("Animate","(animateView.getMeasuredWidth()" + animateView.getMeasuredWidth());

        ValueAnimator animator = ValueAnimator.ofInt(animateView.getMeasuredWidth(), randowValue);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = animateView.getLayoutParams();
                layoutParams.width = val;
                animateView.setLayoutParams(layoutParams);
            }
        });

        animator.setDuration(500);
        animator.start();
    }
}
