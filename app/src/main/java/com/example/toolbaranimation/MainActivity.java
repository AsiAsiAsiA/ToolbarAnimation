package com.example.toolbaranimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvCountBonus = findViewById(R.id.tv_count_bonus);
        NestedScrollView nsv = findViewById(R.id.nsv);
        LinearLayout linearLayout = findViewById(R.id.main_ll);
    }
}
