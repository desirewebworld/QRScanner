package com.scanoverify.qrscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileActivity extends AppCompatActivity {

    CardView userRegisterBtn;
    String name,mobile,password,password_retype,otp;
    public static  RegisterActivity  registerActivity = null;
    LinearLayout progressBar;
    TextInputEditText mobileET,userNameET,userPasswordET,confirmPasswordET,otpET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}