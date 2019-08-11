package com.example.toolbaranimation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;

public class TriggerBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {

    public TriggerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedPreScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull AppBarLayout child,
            @NonNull View target,
            int dx,
            int dy,
            @NonNull int[] consumed,
            int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        Log.i("NestedScroll", "dy: " + dy);
    }

    @Override
    public void onNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull AppBarLayout child,
            @NonNull View target,
            int dxConsumed, int dyConsumed,
            int dxUnconsumed, int dyUnconsumed,
            int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);

        Log.i("NestedScroll", "dyConsumed: " + dyConsumed);

        TextView tvCountBonus = coordinatorLayout.findViewById(R.id.tv_count_bonus);
        NestedScrollView nsv = coordinatorLayout.findViewById(R.id.nsv);

        int height = tvCountBonus.getHeight();
        tvCountBonus.setHeight(height - dyConsumed);
//        nsv.scrollTo(0,0);

//        if (height > 0){
//            tvCountBonus.setHeight(height - dyConsumed);
//            nsv.scrollTo(0,0);
//        } else {
//            float y = tvCurrentBO.getY();
//            tvCurrentBO.setY(y-dyConsumed);
//        }
    }

    @Override
    public void onStopNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull AppBarLayout child,
            @NonNull View target,
            int type) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }
}
