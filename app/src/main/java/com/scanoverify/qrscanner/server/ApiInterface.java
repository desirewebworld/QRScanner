package com.scanoverify.qrscanner.server;


import com.scanoverify.qrscanner.response.OTPSendResponse;
import com.scanoverify.qrscanner.response.UserLoginResponse;
import com.scanoverify.qrscanner.response.UserRegisterResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface
{


 @Multipart
    @POST("forgot-password")
    Call<OTPSendResponse> forgot_password( @Part("mobile") RequestBody mobile_no);

 @Multipart
    @POST("send-register-otp")
    Call<OTPSendResponse> send_register_otp(
         @HeaderMap Map<String,String> headers, @Part("mobile_no") RequestBody mobile_no);

    @POST("logout")
    Call<OTPSendResponse> logout(  @HeaderMap Map<String,String> headers);

     @Multipart
    @POST("user-register")
    Call<UserRegisterResponse> user_register(

            @Part("name") RequestBody name,
            @Part("mobile") RequestBody mobile,
            @Part("password") RequestBody password,
            @Part("password_retype") RequestBody password_retype,
            @Part("otp") RequestBody otp
            );

    @Multipart
    @POST("reset-password")
    Call<OTPSendResponse> change_password(
             @HeaderMap Map<String,String> headers,
            @Part("password") RequestBody password,
            @Part("password_retype") RequestBody password_retype
            );

    @Multipart
    @POST("user-login")
    Call<UserLoginResponse> user_login(
            @Part("mobile_no") RequestBody mobile,
            @Part("password") RequestBody password


    );


}
