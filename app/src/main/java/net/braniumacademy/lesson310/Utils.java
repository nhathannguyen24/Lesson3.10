package net.braniumacademy.lesson310;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final String format = "dd/MM/yyyy"; // 01/01/2001
    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(format);

    public static Date stringToDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (java.text.ParseException ignored) {
            return null;
        }
    }

    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }
}
