package com.scanoverify.qrscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.scanoverify.qrscanner.ui.login.LoginActivity;
import com.scanoverify.qrscanner.util.Desire_Constants;
import com.scanoverify.qrscanner.util.ServerCalls;
import com.scanoverify.qrscanner.util.Util;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout tv_logout,tv_change_password,progressBar,tv_profile;
    public static DashboardActivity dashboardActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ui_init();
        dashboardActivity = this;
    }

    private void ui_init() {
        progressBar = (LinearLayout)findViewById(R.id.progressBar);
        tv_profile = (LinearLayout)findViewById(R.id.tv_profile);
        tv_logout = (LinearLayout)findViewById(R.id.tv_logout);
        tv_change_password = (LinearLayout)findViewById(R.id.tv_change_password);
        tv_logout.setOnClickListener(this);
        tv_profile.setOnClickListener(this);
        tv_change_password.setOnClickListener(this);
        show_progress(false);

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


    public void success(String message)
    {
        show_progress(false);
        Util.show_msg(this,message);
        save_pref();
        show_login_activity();
        finish();

    }

    private void save_pref() {
        String str="";
        SharedPreferences sharedPreferences=  getSharedPreferences(Desire_Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();

        editor.putString("login_mobile","");
        editor.putString("password","");

        editor.commit();
    }
    public void show_error(String message, String error_code) {
        show_progress(false);
        Util.show_error_msg(this,message,error_code);
    }

    private void show_login_activity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
    private void show_change_password_activity() {
        Intent i = new Intent(this, ChangePasswordActivity.class);
        startActivity(i);
    }
    private void show_profile_activity() {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.tv_logout:
            {
                show_progress(true);
                ServerCalls.logout();
                break;
            }
            case R.id.tv_profile:
            {
                show_profile_activity();
                break;
            }
            case R.id.tv_change_password:
            {
                show_change_password_activity();
                break;
            }

        }
    }
}