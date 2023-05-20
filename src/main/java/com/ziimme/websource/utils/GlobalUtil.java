package com.ziimme.websource.utils;

import java.util.Date;

public class GlobalUtil {
    public static Date getCurrentDateTime() {
        return new Date();
    }

    public static String getActiveStatus() {
        return "A";
    }

    public static String getInActiveStatus() {
        return "I";
    }
}
