package com.ziimme.websource.utils;

import org.json.JSONObject;

public class TokenUtil {

    public static String getUserId(String tokenRequest) {
        String userid = "";
        if (!tokenRequest.equals("")) {
            JSONObject requestJson = new JSONObject(tokenRequest);
            userid = JsonUtil.getString(requestJson, "user_id");
        }
        return userid;
    }

    public static String getUsername(String tokenRequest) {
        String username = "";
        if (!tokenRequest.equals("")) {
            JSONObject requestJson = new JSONObject(tokenRequest);
            username = JsonUtil.getString(requestJson, "username");
        }
        return username;
    }

    public static String getDisplayName(String tokenRequest) {
        String displayname = "";
        if (!tokenRequest.equals("")) {
            JSONObject requestJson = new JSONObject(tokenRequest);
            displayname = JsonUtil.getString(requestJson, "displayname");
        }
        return displayname;
    }

    public static String getUserRole(String tokenRequest) {
        String status = "";
        if (!tokenRequest.equals("")) {
            JSONObject requestJson = new JSONObject(tokenRequest);
            status = JsonUtil.getString(requestJson, "status");
        }
        return status;
    }
}
