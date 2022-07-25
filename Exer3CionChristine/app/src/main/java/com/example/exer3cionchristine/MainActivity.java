package com.example.exer3cionchristine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10,med,mave;
    EditText fed1,fed2,fed3,fed4,fed5,fed6,fed7,fed8,fed9,fed10,fed,fave,subgrade,gqd;
    Button btnOK, btnCLR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.foxx);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbar)));
        //Custom image actionbar
        //getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Logo in action bar
        //getActionBar().setDisplayShowCustomEnabled(true);
        //LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.actionbar_logo, null);
        //getActionBar().setCustomView(view);

        //Midterm View
        ed1= findViewById(R.id.mww1);
        ed2 = findViewById(R.id.mww2);
        ed3 = findViewById(R.id.mww3);
        ed4 = findViewById(R.id.mww4);
        ed5 = findViewById(R.id.mww5);

        ed6 = findViewById(R.id.mpt1);
        ed7 = findViewById(R.id.mpt2);
        ed8 = findViewById(R.id.mpt3);
        ed9 = findViewById(R.id.mpt4);
        ed10 = findViewById(R.id.mpt5);

        med = findViewById(R.id.me);

        mave = findViewById(R.id.mta);

        //Final View
        fed1= findViewById(R.id.fww1);
        fed2 = findViewById(R.id.fww2);
        fed3 = findViewById(R.id.fww3);
        fed4 = findViewById(R.id.fww4);
        fed5 = findViewById(R.id.fww5);

        fed6 = findViewById(R.id.fpt1);
        fed7 = findViewById(R.id.fpt2);
        fed8 = findViewById(R.id.fpt3);
        fed9 = findViewById(R.id.fpt4);
        fed10 = findViewById(R.id.fpt5);

        fed = findViewById(R.id.fe);

        fave = findViewById(R.id.fta);

        subgrade = findViewById(R.id.fsg);

        gqd = findViewById(R.id.ged);

        btnOK = findViewById(R.id.btnOK);
        btnCLR = findViewById(R.id.btnCLR);

        btnCLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            markscal();
            }
        });

    }
    public void markscal(){

        int mw1,mw2,mw3,mw4,mw5,mp1,mp2,mp3,mp4,mp5,mee,wtot,ptot;
        int fw1,fw2,fw3,fw4,fw5,fp1,fp2,fp3,fp4,fp5,fee,fwtot,fptot;
        double sw,sp,sm,midAve,fsw,fsp,fsf,finAve;
        float  sg;

        //Midterm Convert
        mw1 = Integer.parseInt(ed1.getText().toString());
        mw2 = Integer.parseInt(ed2.getText().toString());
        mw3 = Integer.parseInt(ed3.getText().toString());
        mw4 = Integer.parseInt(ed4.getText().toString());
        mw5 = Integer.parseInt(ed5.getText().toString());

        mp1 = Integer.parseInt(ed6.getText().toString());
        mp2 = Integer.parseInt(ed7.getText().toString());
        mp3 = Integer.parseInt(ed8.getText().toString());
        mp4 = Integer.parseInt(ed9.getText().toString());
        mp5 = Integer.parseInt(ed10.getText().toString());

        mee = Integer.parseInt(med.getText().toString());

        //Final Convert
        fw1 = Integer.parseInt(fed1.getText().toString());
        fw2 = Integer.parseInt(fed2.getText().toString());
        fw3 = Integer.parseInt(fed3.getText().toString());
        fw4 = Integer.parseInt(fed4.getText().toString());
        fw5 = Integer.parseInt(fed5.getText().toString());

        fp1 = Integer.parseInt(fed6.getText().toString());
        fp2 = Integer.parseInt(fed7.getText().toString());
        fp3 = Integer.parseInt(fed8.getText().toString());
        fp4 = Integer.parseInt(fed9.getText().toString());
        fp5 = Integer.parseInt(fed10.getText().toString());

        fee = Integer.parseInt(fed.getText().toString());



        //Midterm Formula
        wtot = ((mw1+mw2+mw3+mw4+mw5)/5);
        sw   =  wtot*.25;
        ptot = ((mp1+mp2+mp3+mp4+mp5)/5);
        sp   = ptot*.45;
        sm   = mee*.30;

        midAve = (float)Math.round(sm+sw+sp)*.50;

        mave.setText(String.valueOf(midAve));

        //Final term Formula
        fwtot = ((fw1+fw2+fw3+fw4+fw5)/5);
        fsw   =  fwtot*.25;
        fptot = ((fp1+fp2+fp3+fp4+fp5)/5);
        fsp   = fptot*.45;
        fsf   = fee*.30;

        finAve = (float)Math.round(fsf+fsw+fsp)*.50;

        fave.setText(String.valueOf(finAve));

        sg = (float) Math.round(midAve+finAve);

        subgrade.setText(String.valueOf(sg));

        if (sg >= 97){
            gqd.setText("1.00 Highly Excellent");
        }
        else if (sg <= 96 && sg >= 94){
            gqd.setText("1.25 Excellent");
        }
        else if (sg <= 93 && sg >= 91){
            gqd.setText("1.50  Very Superior");
        }
        else if (sg <= 90 && sg >= 88){
            gqd.setText("1.75  Superior");
        }
        else if (sg <= 87 && sg >= 85){
            gqd.setText("2.00  Very Good");
        }
        else if (sg <= 84 && sg >= 82){
            gqd.setText("2.25  Good");
        }
        else if (sg <= 81 && sg >= 79){
            gqd.setText("2.50  Satisfactory");
        }
        else if (sg <= 78 && sg >= 76){
            gqd.setText("2.75  Fair");
        }
        else if (sg == 75){
            gqd.setText("3.00 PASSED");
        }
        else{
            gqd.setText("FAILED");
        }


    }
    public void clear()
    {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        ed6.setText("");
        ed7.setText("");
        ed8.setText("");
        ed9.setText("");
        ed10.setText("");
        med.setText("");
        mave.setText("");

        fed1.setText("");
        fed2.setText("");
        fed3.setText("");
        fed4.setText("");
        fed5.setText("");
        fed6.setText("");
        fed7.setText("");
        fed8.setText("");
        fed9.setText("");
        fed10.setText("");
        fed.setText("");
        fave.setText("");

        subgrade.setText("");
        gqd.setText("");

    }

}

