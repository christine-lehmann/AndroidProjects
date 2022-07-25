package com.example.exer1cionchristine;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClear(View view) {
        Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();
    }

    public void onPara(View view) {
        Toast.makeText(this, "()", Toast.LENGTH_SHORT).show();
    }

    public void onPower(View view) {
        Toast.makeText(this, "^", Toast.LENGTH_SHORT).show();
    }

    public void onDivide(View view) {
        Toast.makeText(this, "÷", Toast.LENGTH_SHORT).show();
    }

    public void onSeven(View view) {
        Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
    }

    public void onEight(View view) {
        Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
    }

    public void onNine(View view) {
        Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
    }

    public void onMultiply(View view) {
        Toast.makeText(this, "×", Toast.LENGTH_SHORT).show();
    }

    public void onFour(View view) {
        Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
    }

    public void onFive(View view) {
        Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
    }

    public void onSix(View view) {
        Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
    }

    public void onSubtract(View view) {
        Toast.makeText(this, "-", Toast.LENGTH_SHORT).show();
    }

    public void onOne(View view) {
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
    }

    public void onTwo(View view) {
        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
    }

    public void onThree(View view) {
        Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
    }

    public void onAdd(View view) {
        Toast.makeText(this, "+", Toast.LENGTH_SHORT).show();
    }

    public void onZero(View view) {
        Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
    }

    public void onPoint(View view) {
        Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
    }

    public void onEqual(View view) {
        Toast.makeText(this, "=", Toast.LENGTH_SHORT).show();
    }

}
