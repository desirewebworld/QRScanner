package com.scanoverify.qrscanner.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OTPSendResponse implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("info")
    @Expose
    private Info info;
    private final static long serialVersionUID = -2655674894073164875L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

public class Info implements Serializable {

    @SerializedName("mobile_no")
    @Expose
    private List<String> mobileNo = null;
    private final static long serialVersionUID = 8308281732637701377L;

    public List<String> getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(List<String> mobileNo) {
        this.mobileNo = mobileNo;
    }
    }

}