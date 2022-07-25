package com.example.exer5cionchristine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otp extends AppCompatActivity {
    EditText t2;
    Button btn2;
    String phonenumber;
    String otpid;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        phonenumber = getIntent().getStringExtra("mobile");
        t2 = (EditText)findViewById(R.id.t2);
        btn2 = (Button)findViewById(R.id.btn2);
        mAuth = FirebaseAuth.getInstance();


        initiateotp();

        btn2.setOnClickListener(view -> {
            if(t2.getText().toString().isEmpty())
                Toast.makeText(getApplicationContext(),"Blank field can not be processed",Toast.LENGTH_LONG).show();
            else if(t2.getText().toString().length()!=6)
                Toast.makeText(getApplicationContext(),"Invalid OTP",Toast.LENGTH_LONG).show();
            else {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpid, t2.getText().toString());
                signInWithPhoneAuthCredential(credential);
            }
        });

    }

    private void initiateotp() {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phonenumber,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        otpid=s;
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }); //OnVerificationStateChangedCallbacks


    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(otp.this, ListActivity.class));
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Signing Code Error", Toast.LENGTH_LONG).show();
                    }
                });
    }



}
