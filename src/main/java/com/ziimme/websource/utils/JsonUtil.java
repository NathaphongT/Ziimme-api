package com.ziimme.websource.utils;

import org.json.JSONObject;

public class JsonUtil {
    public static String getString(JSONObject jsonObject, String key) {
        return (jsonObject.isNull(key)) ? null : jsonObject.getString(key);
    }

    public static int getInt(JSONObject jsonObject, String key) {
        return (jsonObject.isNull(key)) ? 0 : jsonObject.getInt(key);
    }

    public static Long getLong(JSONObject jsonObject, String key) {
        return (jsonObject.isNull(key)) ? 0 : jsonObject.getLong(key);
    }

    public static float getFloat(JSONObject jsonObject, String key) {
        return (jsonObject.isNull(key)) ? 0.00f : jsonObject.getFloat(key);
    }

    public static boolean getBool(JSONObject jsonObject, String key) {
        return (jsonObject.isNull(key)) ? false : jsonObject.getBoolean(key);
    }

    public static double getDouble(JSONObject jsonObject, String key) {
        return (jsonObject.isNull(key)) ? 0.00 : Double.parseDouble(String.format("%.3f", jsonObject.getDouble(key)));
    }
}
