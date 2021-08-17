

package com.scanoverify.qrscanner.response;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserLoginResponse implements Serializable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user_data")
    @Expose
    private UserData userData;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    private final static long serialVersionUID = -2365641964571140964L;

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

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }


    public class UserData implements Serializable
    {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("email")
        @Expose
        private Object email;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("email_verified_at")
        @Expose
        private Object emailVerifiedAt;
        @SerializedName("firm_name")
        @Expose
        private Object firmName;
        @SerializedName("firm_image")
        @Expose
        private Object firmImage;
        @SerializedName("profile_image")
        @Expose
        private Object profileImage;
        @SerializedName("address")
        @Expose
        private Object address;
        @SerializedName("web_url")
        @Expose
        private Object webUrl;
        @SerializedName("helpline")
        @Expose
        private Object helpline;
        @SerializedName("sector")
        @Expose
        private Object sector;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        private final static long serialVersionUID = -4544346355196272247L;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }

        public Object getFirmName() {
            return firmName;
        }

        public void setFirmName(Object firmName) {
            this.firmName = firmName;
        }

        public Object getFirmImage() {
            return firmImage;
        }

        public void setFirmImage(Object firmImage) {
            this.firmImage = firmImage;
        }

        public Object getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(Object profileImage) {
            this.profileImage = profileImage;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(Object webUrl) {
            this.webUrl = webUrl;
        }

        public Object getHelpline() {
            return helpline;
        }

        public void setHelpline(Object helpline) {
            this.helpline = helpline;
        }

        public Object getSector() {
            return sector;
        }

        public void setSector(Object sector) {
            this.sector = sector;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }


}