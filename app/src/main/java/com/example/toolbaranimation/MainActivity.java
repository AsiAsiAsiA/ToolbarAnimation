package com.example.toolbaranimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements RvAdapter.ClickListener {
    Button btn;
    View animateView;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        animateView = findViewById(R.id.animateView);
        rv = findViewById(R.id.rv);
//        btn.setOnClickListener(v -> onClick());

        RvAdapter rvAdapter = new RvAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(rvAdapter);
    }

    private void onClick(int width) {
//        int randowValue = new Random().nextInt(1000);
        Log.i("Animate","(animateView.getMeasuredWidth()" + animateView.getMeasuredWidth());

        ValueAnimator animator = ValueAnimator.ofInt(animateView.getMeasuredWidth(), width);
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

    @Override
    public void viewHolderClick(int width) {
        onClick(width);
        Toast.makeText(this, ""+width, Toast.LENGTH_SHORT).show();
    }
}
