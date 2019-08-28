package com.example.toolbaranimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements RvAdapter.ClickListener {
    Button btn;
    TextView textView;
    View animateView;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        animateView = findViewById(R.id.animateView);
        rv = findViewById(R.id.rv);
        btn.setOnClickListener(v -> changeTextView());

        RvAdapter rvAdapter = new RvAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(rvAdapter);
    }

    //Изменение параметров textView в RUNTIME
    private void changeTextView() {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
    }

    private void onClick(int width) {
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
