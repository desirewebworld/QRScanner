package com.scanoverify.qrscanner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.scanoverify.qrscanner.core.UserDetails;
import com.scanoverify.qrscanner.ui.login.LoginActivity;
import com.scanoverify.qrscanner.util.Desire_Constants;
import com.scanoverify.qrscanner.util.ServerCalls;
import com.scanoverify.qrscanner.util.Util;
import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {

    public static MainActivity  mainActivity = null;
    AlertDialog.Builder builder;
    Alerter alerter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        start_our_process();
        // setActionBar("Free Demat Account Opening App");
        //start_service();
    }

    private void start_our_process() {
        if(isNetworkConnected() == false)
        {
            Util.show_sack(findViewById(android.R.id.content).getRootView(), Desire_Constants.INTERNET_NOT_WORKING_MSG);

        }
        check_login();
        mainActivity = this;
    }

    boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    @Override
    protected void onPostResume() {

        super.onPostResume();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    public void setActionBar(String heading) {
        // TODO Auto-generated method stub


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        actionBar.setTitle(heading);
        actionBar.show();
    }
    void run_flash()
    {
        final Intent myintent = new Intent(this, LoginActivity.class);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                startActivity(myintent);
                finish();

            }
        }, 0000);
    }



    String username, password;
    boolean read_pref()
    {
        //return false;
        String str="";
        SharedPreferences sharedPreferences =  getSharedPreferences(Desire_Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences == null)
        {
            return false;
        }
        username = sharedPreferences.getString("login_mobile", null);
        password = sharedPreferences.getString("password", null);
             return true;
    }
    void check_login()
    {
        if(read_pref() == false)
        {
            run_flash();
        }
        else
        {
            if( (username != null) && (password != null) &&
            (username.equalsIgnoreCase("") == false) && (password.equalsIgnoreCase("") == false))
            {
                ServerCalls.call_from = 2;
                ServerCalls.user_login(username,password);
            }
            else
            {
                show_login_activity();
            }

        }
    }




    public void show_error(String message , String code)
    {
        Util.show_error_msg(this,message,code);
        ServerCalls.call_from = 0;
       show_login_activity();
    }

    private void show_login_activity() {
        final Intent myintent = new Intent(this, LoginActivity.class);
        startActivity(myintent);
        finish();
    }

    public void success(String message)
    {
        Util.show_msg(this,message);
        ServerCalls.call_from = 0;
        Util.show_msg(this,message);
       show_dashboard_activity();
    }

    private void show_dashboard_activity() {
        final Intent myintent = new Intent(this, DashboardActivity.class);
        startActivity(myintent);
        finish();
    }


}