package com.ziimme.websource.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FormatUtil {
    public static String format(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        DecimalFormat df = new DecimalFormat("###.#");

        return String.format("%s%c", df.format(count / Math.pow(1000, exp)), "kMGTPE".charAt(exp-1));
    }

    public static String formatWithComma(long value) {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(value);
    }

    public static String formatDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dateStr);
            dateStr = new SimpleDateFormat("MMMM dd, yyyy").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static String formatDateRange(String startDateStr, String endDateStr) {
        String dateStr = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = formatter.parse(startDateStr);
            Date endDate = formatter.parse(endDateStr);

            if (startDate.getYear() == endDate.getYear()) {
                startDateStr = new SimpleDateFormat("MMMM dd").format(startDate);
            } else {
                startDateStr = new SimpleDateFormat("MMMM dd, yyyy").format(startDate);
            }
            endDateStr = new SimpleDateFormat("MMMM dd, yyyy").format(endDate);

            dateStr = startDateStr + " - " + endDateStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static String formatDateTime(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = formatter.parse(dateStr);
            //dateStr = new SimpleDateFormat("MMMM dd, yyyy 'at' hh:mm aa").format(date);
            dateStr = new SimpleDateFormat("dd/MM/yyyy '-' HH:mm:ss").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static Long getTimeStamp(String dateStr, String pattern) {
        Date date = new Date();
        Long mill = date.getTime();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            date = formatter.parse(dateStr);
            mill = date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mill;
    }
}
