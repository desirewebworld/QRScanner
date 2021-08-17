package com.scanoverify.qrscanner.ui.login;

import android.app.Activity;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.scanoverify.qrscanner.DashboardActivity;
import com.scanoverify.qrscanner.ForgetPasswordActivity;
import com.scanoverify.qrscanner.R;
import com.scanoverify.qrscanner.RegisterActivity;
import com.scanoverify.qrscanner.GenerateOTPActivity;
import com.scanoverify.qrscanner.util.Desire_Constants;
import com.scanoverify.qrscanner.util.ServerCalls;
import com.scanoverify.qrscanner.util.Util;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginViewModel loginViewModel;
    public static View rootview  = null;
    LinearLayout progressBar;
    public static LoginActivity loginActivity = null;
    String mobile, password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginActivity = this;
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
          rootview  = findViewById(android.R.id.content).getRootView();
        if(isNetworkConnected() == false)
        {
            Util.show_sack(rootview, Desire_Constants.INTERNET_NOT_WORKING_MSG);

        }


        final TextInputEditText usernameEditText = findViewById(R.id.phoneEt);
        final TextInputEditText passwordEditText = findViewById(R.id.passEt);
        final CardView loginButton = findViewById(R.id.loginBtn);
        final LinearLayout loadingProgressBar = findViewById(R.id.loginProgressLyt);
        progressBar = findViewById(R.id.loginProgressLyt);
        final TextView registerBtn = findViewById(R.id.registerBtn);
        AppCompatTextView forgotPassBtn = findViewById(R.id.forgotPassBtn);
        registerBtn.setOnClickListener(this);
        forgotPassBtn.setOnClickListener(this);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }

                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                mobile =  usernameEditText.getText().toString();
                password=       passwordEditText.getText().toString();
                show_progress(true);
                if(check_value())
                {
                    ServerCalls.user_login(mobile,password);
                }

                //Complete and destroy login activity once successful

            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());



            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
//        String welcome = getString(R.string.welcome) + model.getDisplayName();
//        // TODO : initiate successful logged in experience
//        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    public void success(String message)
    {
        save_pref();
        show_progress(false);

        Util.show_msg(this,message);

        show_dashboard_activity();
        finish();

    }

    public void show_error(String message, String error_code) {
        show_progress(false);
        Util.show_error_msg(this,message,error_code);
    }
    private boolean check_value() {

        // we have to put validation // here

        return true;

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

    private void save_pref() {
        String str="";
        SharedPreferences sharedPreferences=  getSharedPreferences(Desire_Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor=sharedPreferences.edit();

        editor.putString("login_mobile",mobile);


        editor.putString("password",password);


        editor.commit();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.registerBtn:
            {
                show_otp_activity();
                break;
            }
            case R.id.forgotPassBtn:
            {
                show_forget_password_activity();
                break;
            }
        }
    }

    private void show_dashboard_activity() {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }


    private void show_forget_password_activity() {
        Intent i = new Intent(this, ForgetPasswordActivity.class);
        startActivity(i);
    }

    private void show_registration_activity() {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


    private void show_otp_activity() {
        Intent i = new Intent(this, GenerateOTPActivity.class);
        startActivity(i);
    }

}