package com.example.ass1_cionchristine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Activity2 extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        viewFlipper = findViewById(R.id.viewFlipper);
        TextView textView = new TextView(this);
        textView.setText("Dynamically added TextView");
        textView.setGravity(Gravity.CENTER);

        viewFlipper.addView(textView);
    }

    public  void previousView(View v){
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setInAnimation(this, R.anim.slide_out_left);
        viewFlipper.showPrevious();
    }
    public void nextView(View v){
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setInAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showNext();
    }
}