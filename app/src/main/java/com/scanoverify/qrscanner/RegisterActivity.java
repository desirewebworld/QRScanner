package com.scanoverify.qrscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    CardView userRegisterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userRegisterBtn = (CardView) findViewById(R.id.userRegisterBtn);
        userRegisterBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.userRegisterBtn:
            {
                show_otp_activity();
                break;
            }
        }
    }

    private void show_otp_activity() {
        Intent i = new Intent(this, VerifyOTPActivity.class);
        startActivity(i);
    }

}