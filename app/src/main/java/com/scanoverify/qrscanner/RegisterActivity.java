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
import com.scanoverify.qrscanner.util.Desire_Constants;
import com.scanoverify.qrscanner.util.ServerCalls;
import com.scanoverify.qrscanner.util.Util;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    CardView userRegisterBtn;
    String name,mobile,password,password_retype,otp;
    public static  RegisterActivity  registerActivity = null;
    LinearLayout progressBar;
    TextInputEditText mobileET,userNameET,userPasswordET,confirmPasswordET,otpET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ui_init();
        registerActivity = this;

    }

    private void ui_init() {
        mobileET = (TextInputEditText) findViewById(R.id.mobileET);
        userNameET = (TextInputEditText) findViewById(R.id.userNameET);
        userPasswordET = (TextInputEditText) findViewById(R.id.userPasswordET);
        confirmPasswordET = (TextInputEditText) findViewById(R.id.confirmPasswordET);
        otpET = (TextInputEditText) findViewById(R.id.otpET);
        progressBar = (LinearLayout) findViewById(R.id.progressBar);
        show_progress(false);

        userRegisterBtn = (CardView) findViewById(R.id.userRegisterBtn);
        userRegisterBtn.setOnClickListener(this);
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
            case R.id.userRegisterBtn:
            {
                if(check_value())
                {
                    show_progress(true);
                    ServerCalls.user_register( name, mobile, password, password_retype, otp );
                }

                break;
            }
        }
    }

    private boolean check_value() {

      // we have to put validation // here
        name =userNameET.getText().toString();
        password =userPasswordET.getText().toString();
        password_retype =confirmPasswordET.getText().toString();
        otp =otpET.getText().toString();
        mobile =mobileET.getText().toString();
        return true;

    }

    private void save_pref() {
        String str="";
        SharedPreferences sharedPreferences=  getSharedPreferences(Desire_Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();

        editor.putString("name",name);
        editor.putString("mobile",mobile);
        editor.putString("login_mobile",mobile);
        editor.putString("password",password);

        editor.commit();
    }

    private void show_otp_activity() {
        Intent i = new Intent(this, GenerateOTPActivity.class);
        startActivity(i);
    }

    private void show_dashboard_activity() {
        show_progress(false);
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

    public void success(String message)
    { show_progress(false);
        Util.show_msg(this,message);
        show_dashboard_activity();
        finish();

    }
    public void show_error(String message, String error_code) {
        show_progress(false);
        Util.show_error_msg(this,message,error_code);
    }


}