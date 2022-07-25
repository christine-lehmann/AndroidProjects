package com.example.mtlabe_cionchristine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.bank);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));

        String [] type = new String[] {"Under Php 10,000","Php 10,001 to Php 25,000","Php 25,001 to Php 50,000","Over Php 50,001"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                this,
                R.layout.drop_down,
                type
                
        );


        AutoCompleteTextView autoCompleteTextView=findViewById(R.id.filledexposed);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l ){
                Toast.makeText(MainActivity.this,autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}