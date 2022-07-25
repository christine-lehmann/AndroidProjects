package com.example.exer5cionchristine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class mobile extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText t1;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);

        t1 = (EditText)findViewById(R.id.t1);
        ccp = (CountryCodePicker)findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(t1);
        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(view -> {
            Intent intent = new Intent(mobile.this,otp.class);
            intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace("",""));
            startActivity(intent);
        });

    }
}