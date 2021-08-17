package com.scanoverify.qrscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.scanoverify.qrscanner.ui.login.LoginActivity;
import com.scanoverify.qrscanner.util.Desire_Constants;
import com.scanoverify.qrscanner.util.ServerCalls;
import com.scanoverify.qrscanner.util.Util;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    CardView doneBtn;
    String name,mobile,password,password_retype,otp;
    public static  ChangePasswordActivity  changePasswordActivity = null;
    LinearLayout progressBar;
    TextInputEditText mobileET,userNameET,userPasswordET,confirmPasswordET,otpET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        changePasswordActivity = this;
        ui_init();
    }

    private void ui_init() {

        userPasswordET = (TextInputEditText) findViewById(R.id.userPasswordET);
        confirmPasswordET = (TextInputEditText) findViewById(R.id.confirmPassEt);

        progressBar = (LinearLayout) findViewById(R.id.progressBar);
        show_progress(false);

        doneBtn = (CardView) findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(this);
    }
    private void show_progress(boolean is_show) {

        if(is_show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.GONE);
        }

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.doneBtn:
            {
                if(check_value())
                {
                    show_progress(true);
                    ServerCalls.change_password( password, password_retype);
                }

                break;
            }
        }
    }

    private boolean check_value() {

        // we have to put validation // here

        password =userPasswordET.getText().toString();
        password_retype =confirmPasswordET.getText().toString();

        return true;

    }


    private void show_login_activity() {
        show_progress(false);
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void success(String message)
    {
        show_progress(false);
        Util.show_msg(this,message);
        show_login_activity();
        finish();

    }
    public void show_error(String message, String error_code) {
        show_progress(false);
        Util.show_error_msg(this,message,error_code);
    }



}