package com.scanoverify.qrscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.scanoverify.qrscanner.util.ServerCalls;
import com.scanoverify.qrscanner.util.Util;

public class GenerateOTPActivity extends AppCompatActivity implements View.OnClickListener {

    CardView submitBtn;
    public static GenerateOTPActivity generateOTPActivity = null;
    String phone = "";
    LinearLayout progressBar;
    TextInputEditText phoneEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);
       init_ui();
        generateOTPActivity = this;
    }

    private void init_ui() {
        submitBtn = (CardView) findViewById(R.id.submitBtn);
        progressBar = (LinearLayout) findViewById(R.id.progressBar);
        show_progress(false);
        phoneEt = (TextInputEditText) findViewById(R.id.phoneEt);
        //phoneEt.setText("7007702307");
        submitBtn.setOnClickListener(this);
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
        show_register_user_activity();
        finish();

    }
    public void show_error(String message, String error_code) {
        show_progress(false);
        Util.show_error_msg(this,message,error_code);
    }

    private void show_register_user_activity() {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.submitBtn:
            {

                if(check_value())
                {
                    show_progress(true);
                    ServerCalls.send_otp(phone);
                }

                break;
            }

        }
    }

    private boolean check_value() {
        // validation has to put here

        phone = phoneEt.getText().toString();
        return true;
    }
}