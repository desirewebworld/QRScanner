package com.scanoverify.qrscanner.util;

import android.text.TextUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerCalls {

    private static final String USING_APP = "USING DESIRE APP";

    public static int call_from = 0;
    public static String token_key = new String();
    public static String token_id = new String();
    public static String header[] ;
    public static List<String> request_header = new ArrayList<String>();
    public static String APP_JSON = "application/json";
    public static HashMap<String, String> headers = new HashMap<String, String>();




}
