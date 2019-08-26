package com.example.toolbaranimation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {
    private int count;
    private ClickListener clickListener;

    RvAdapter(ClickListener clickListener) {
        count = new Random().nextInt(10) + 2;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return count;
    }

    interface ClickListener {
        void viewHolderClick(int width);
    }

    class RvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        int width;

        RvViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(this);
        }

        void bind() {
            int a = new Random().nextInt(Integer.MAX_VALUE);
            textView.setText(String.valueOf(a));

            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    width = textView.getWidth();
                }
            });
        }

        @Override
        public void onClick(View view) {
            clickListener.viewHolderClick(width);
        }
    }
}
