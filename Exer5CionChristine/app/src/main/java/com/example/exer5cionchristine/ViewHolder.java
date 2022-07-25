package com.example.exer5cionchristine;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView mTitleTv, mDescriptionTv;
    View mView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        itemView.setOnClickListener(v -> mClickListener.onItemClick(v, getAdapterPosition()));
        itemView.setOnLongClickListener(v -> {
            mClickListener.onItemLongClick(v, getAdapterPosition());
            return true;
        });
        mTitleTv = itemView.findViewById(R.id.rTitleTv);
        mDescriptionTv = itemView.findViewById(R.id.rDescriptionTv);

    }
    private ViewHolder.ClickListener mClickListener;
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
