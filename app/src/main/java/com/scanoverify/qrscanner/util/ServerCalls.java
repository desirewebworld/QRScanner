package com.scanoverify.qrscanner.util;


import com.scanoverify.qrscanner.ChangePasswordActivity;
import com.scanoverify.qrscanner.DashboardActivity;
import com.scanoverify.qrscanner.ForgetPasswordActivity;
import com.scanoverify.qrscanner.MainActivity;
import com.scanoverify.qrscanner.RegisterActivity;
import com.scanoverify.qrscanner.GenerateOTPActivity;
import com.scanoverify.qrscanner.core.UserDetails;
import com.scanoverify.qrscanner.response.OTPSendResponse;
import com.scanoverify.qrscanner.response.UserLoginResponse;
import com.scanoverify.qrscanner.response.UserRegisterResponse;
import com.scanoverify.qrscanner.server.ApiClient;
import com.scanoverify.qrscanner.server.ApiInterface;
import com.scanoverify.qrscanner.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerCalls {

    private static final String USING_APP = "USING DESIRE APP";
    private static final String BEARER = "Bearer" ;

    public static int call_from = 0;
    public static String token_key = new String();
    public static String token_id = new String();
    public static String header[] ;
    public static List<String> request_header = new ArrayList<String>();
    public static String APP_JSON = "application/json";
    public static String message = "";
    public static HashMap<String, String> headers = new HashMap<String, String>();



    public static void user_login(String mobile_no, String password  )
    {
        headers.put("Content-Type",APP_JSON);
        headers.put("value",APP_JSON);
        headers.put("Accept",APP_JSON);
        /*Request creation*/
        /*Request parameter part*/
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        RequestBody mobile_param = RequestBody.create(MediaType.parse("text/plain"), mobile_no);
        RequestBody password_param = RequestBody.create(MediaType.parse("text/plain"), password);



        /*Request send part*/
        Call<UserLoginResponse> call = apiService.user_login(
                mobile_param,
                password_param
               );
        call.enqueue(new Callback<UserLoginResponse>()
        {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                int row_count = 0, i = 0;

                UserLoginResponse server_response = response.body();
                int code = response.code();

                if (code == 200) {

                    String accessToken;
                    UserDetails  userDetails = UserDetails.getDesireUser();
                    if (server_response.getStatus().equalsIgnoreCase(Desire_Constants.SUCCESS)) {

                        accessToken = server_response.getAccessToken();
                        userDetails.setAccess_token(accessToken);
                        message = server_response.getMessage();
                        if( ServerCalls.call_from == 2)
                        {
                            MainActivity.mainActivity.success(message);
                        }
                        else {
                            LoginActivity.loginActivity.success(message);
                        }
                    }
                    else
                    {
                        message = server_response.getMessage();
                        if( ServerCalls.call_from == 2)
                        {
                            MainActivity.mainActivity.show_error(message, "-12122");
                        }
                        else {

                            LoginActivity.loginActivity.show_error(message, "-12122");
                        }

                    }

                } else {
                    message = "Server error.";
                    if(server_response != null)
                    {
                        message = server_response.getMessage();
                    }
                    if( ServerCalls.call_from == 2)
                    {
                        MainActivity.mainActivity.show_error(message, String.valueOf(code));
                    }
                    else {

                        LoginActivity.loginActivity.show_error(message, String.valueOf(code));
                    }
                }

            }


            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {

                message =t.getMessage();
                if( ServerCalls.call_from == 2)
                {
                     MainActivity.mainActivity.show_error(message,"-12123");
                }
                else {

                    RegisterActivity.registerActivity.show_error(message, "-12123");
                }
            }
        });

    }

    public static void user_register(String name,String mobile,String password,String password_retype,String otp )
    {
        headers.put("Content-Type",APP_JSON);
        headers.put("value",APP_JSON);
        headers.put("Accept",APP_JSON);
        /*Request creation*/
        /*Request parameter part*/
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        RequestBody name_param = RequestBody.create(MediaType.parse("text/plain"), name);
        RequestBody mobile_param = RequestBody.create(MediaType.parse("text/plain"), mobile);
        RequestBody password_param = RequestBody.create(MediaType.parse("text/plain"), password);
        RequestBody password_retype_param = RequestBody.create(MediaType.parse("text/plain"), password_retype);
        RequestBody otp_param = RequestBody.create(MediaType.parse("text/plain"), otp);


        /*Request send part*/
        Call<UserRegisterResponse> call = apiService.user_register(
                name_param,
                mobile_param,
                password_param,
                password_retype_param,
                otp_param);
        call.enqueue(new Callback<UserRegisterResponse>()
        {
            @Override
            public void onResponse(Call<UserRegisterResponse> call, Response<UserRegisterResponse> response) {
                int row_count = 0, i = 0;

                UserRegisterResponse server_response = response.body();
                int code = response.code();

                if (code == 200) {

                    String userId,  name ,mobile, updatedAt, createdAt,accessToken;
                    Integer status,id;
                    UserDetails.User user = new  UserDetails.User();
                    UserDetails  userDetails = UserDetails.getDesireUser();
                    if (server_response.getStatus().equalsIgnoreCase(Desire_Constants.SUCCESS)) {

                        accessToken = server_response.getAccessToken();
                        userDetails.setAccess_token(accessToken);

                        userId = server_response.getUser().getUserId();
                         id = server_response.getUser().getId();
                        status = server_response.getUser().getStatus();
                        name = server_response.getUser().getName();
                        mobile = server_response.getUser().getMobile();
                        updatedAt = server_response.getUser().getCreatedAt();
                        createdAt = server_response.getUser().getUpdatedAt();
                        user.setId(id);
                        user.setStatus(status);
                        user.setName(name);
                        user.setMobile(mobile);
                        user.setUpdatedAt(updatedAt);
                        user.setCreatedAt(createdAt);
                        user.setUserId(userId);
                        userDetails.setUser(user);
                        message = server_response.getMessage();
                        RegisterActivity.registerActivity.success(message);
                    }
                    else
                        {
                        message = server_response.getMessage();
                        RegisterActivity.registerActivity.show_error(message, "-12122");
                    }

                } else {
                    message = "Server error.";
                    if(server_response != null)
                    {
                        message = server_response.getMessage();
                    }
                    RegisterActivity.registerActivity.show_error(message, String.valueOf(code));
                }

            }


            @Override
            public void onFailure(Call<UserRegisterResponse> call, Throwable t) {

                message =t.getMessage();
                RegisterActivity.registerActivity.show_error(message,"-12123");
            }
        });

    }



    public static void change_password(String password,String password_retype)
    {
        String auth = get_autorization();
        /* headers.put("Content-Type",APP_JSON);
         headers.put("value",APP_JSON);
        headers.put("Accept",APP_JSON);
        headers.put("authorization",auth);*/
        DesireLog.Log(auth);
        /*Request creation*/
        HashMap<String, String> other_headers = new HashMap<String, String>();
        other_headers.put("authorization",auth);

        /*Request parameter part*/
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        RequestBody password_param = RequestBody.create(MediaType.parse("text/plain"), password);
        RequestBody password_retype_param = RequestBody.create(MediaType.parse("text/plain"), password_retype);
        /*Request send part*/
        Call<OTPSendResponse> call = apiService.change_password(
                other_headers,
                password_param,
                password_retype_param );

        call.enqueue(new Callback<OTPSendResponse>()
        {
            @Override
            public void onResponse(Call<OTPSendResponse> call, Response<OTPSendResponse> response) {
                int row_count = 0, i = 0;

                OTPSendResponse server_response = response.body();
                int code = response.code();

                if (code == 200) {

                    if (server_response == null  &&
                            server_response.getStatus() == null ) {
                        message = "Server error.";
                        if (server_response != null ) {
                            message = server_response.getMessage();
                        }
                        ChangePasswordActivity.changePasswordActivity.show_error(message, String.valueOf(code));
                    } else {
                        if (server_response.getStatus().equalsIgnoreCase(Desire_Constants.SUCCESS)) {
                            message = server_response.getMessage();
                            ChangePasswordActivity.changePasswordActivity.success(message);
                        } else {
                            message = server_response.getMessage();
                            ChangePasswordActivity.changePasswordActivity.show_error(message, "-12822");
                        }
                    }
                }
                    else{
                        message = "Server error.";
                        if (server_response != null) {
                            message = server_response.getMessage();
                        }
                        ChangePasswordActivity.changePasswordActivity.show_error(message, String.valueOf(code));
                    }



            }


            @Override
            public void onFailure(Call<OTPSendResponse> call, Throwable t) {

                message =t.getMessage();
                ChangePasswordActivity.changePasswordActivity.show_error(message,"-12823");
            }
        });

    }




    public static String get_autorization()
    {
        return BEARER + " " + UserDetails.msDesireUser.getAccess_token();
    }
    public static void logout()
    {


          headers.put("Content-Type",APP_JSON);
          headers.put("value",APP_JSON);

        headers.put("authorization",get_autorization());

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        /*Request send part*/
        Call<OTPSendResponse> call = apiService.logout(headers);
        call.enqueue(new Callback<OTPSendResponse>()
        {
            @Override
            public void onResponse(Call<OTPSendResponse> call, Response<OTPSendResponse> response) {
                int row_count = 0, i = 0;

                OTPSendResponse server_response = response.body();
                int code = response.code();
                if (code == 200) {


                    if (server_response.getStatus().equalsIgnoreCase(Desire_Constants.SUCCESS)) {
                        message = server_response.getMessage();
                       DashboardActivity.dashboardActivity.success(message);
                    } else {
                        message = server_response.getMessage();
                        DashboardActivity.dashboardActivity.show_error(message, "-12522");
                    }

                }
                else
                 {
                    message = "Server Error !";
                    if(server_response != null)
                    {
                        message = server_response.getMessage();
                    }
                     DashboardActivity.dashboardActivity.show_error(message, String.valueOf(code));
                }

            }


            @Override
            public void onFailure(Call<OTPSendResponse> call, Throwable t) {

                message =t.getMessage();
                DashboardActivity.dashboardActivity.show_error(message,"-12523");
            }
        });

    }


    public static void send_otp(String phone)
    {
         // headers.put("Content-Type",APP_JSON);

        HashMap<String, String> other_headers = new HashMap<String, String>();
        other_headers.put("Content-Type",APP_JSON);

        /*Request creation*/
        /*Request parameter part*/
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        RequestBody phone_param = RequestBody.create(MediaType.parse("text/plain"), phone);


        /*Request send part*/
        Call<OTPSendResponse> call = apiService.send_register_otp( other_headers, phone_param);
        call.enqueue(new Callback<OTPSendResponse>()
        {

            @Override
            public void onResponse(Call<OTPSendResponse> call, Response<OTPSendResponse> response) {
                int row_count = 0, i = 0;

                OTPSendResponse otpSendResponse = response.body();
                int code = response.code();
                if (code == 200) {


                    if (otpSendResponse.getStatus().equalsIgnoreCase(Desire_Constants.SUCCESS)) {
                        message = otpSendResponse.getMessage();
                        GenerateOTPActivity.generateOTPActivity.success(message);
                    } else {
                        message = otpSendResponse.getMessage();
                        GenerateOTPActivity.generateOTPActivity.show_error(message, "-12022");
                    }

                }
                else
                 {
                    message = "Server error !";
                    if(otpSendResponse != null)
                    {
                        message = otpSendResponse.getMessage();
                    }
                    else
                    {
                        DesireLog.Log("otpSendResponse is null");
                        DesireLog.Log("Body Response  : " + response.body().toString());
                    }
                    GenerateOTPActivity.generateOTPActivity.show_error(message, String.valueOf(code));
                }

            }


            @Override
            public void onFailure(Call<OTPSendResponse> call, Throwable t) {

                message =t.getMessage();
                    GenerateOTPActivity.generateOTPActivity.show_error(message,"-12023");
            }
        });

    }



    public static void forget_password(String phone)
    {
        headers.put("Content-Type",APP_JSON);
        headers.put("value",APP_JSON);
        /*Request creation*/
        /*Request parameter part*/
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        RequestBody phone_param = RequestBody.create(MediaType.parse("text/plain"), phone);


        /*Request send part*/
        Call<OTPSendResponse> call = apiService.forgot_password(phone_param);
        call.enqueue(new Callback<OTPSendResponse>()
        {
            @Override
            public void onResponse(Call<OTPSendResponse> call, Response<OTPSendResponse> response) {
                int row_count = 0, i = 0;

                OTPSendResponse otpSendResponse = response.body();
                int code = response.code();
                if (code == 200) {


                    if (otpSendResponse.getStatus().equalsIgnoreCase(Desire_Constants.SUCCESS)) {
                        message = otpSendResponse.getMessage();
                        ForgetPasswordActivity.forgetPasswordActivity.success(message);
                    } else {
                        message = otpSendResponse.getMessage();
                        ForgetPasswordActivity.forgetPasswordActivity.show_error(message, "-12022");
                    }

                }
                else
                {
                    message = "Server Error !";
                    if(otpSendResponse != null)
                    {
                        message = otpSendResponse.getMessage();
                    }
                    ForgetPasswordActivity.forgetPasswordActivity.show_error(message, String.valueOf(code));
                }

            }


            @Override
            public void onFailure(Call<OTPSendResponse> call, Throwable t) {

                message =t.getMessage();
                ForgetPasswordActivity.forgetPasswordActivity.show_error(message,"-12023");
            }
        });

    }



}
