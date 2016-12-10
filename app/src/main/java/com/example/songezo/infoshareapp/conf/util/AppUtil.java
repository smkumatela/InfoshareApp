package com.example.songezo.infoshareapp.conf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public class AppUtil {

    public static Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date value = null;
        try {
            value = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getBaserURI(){
        return "localhost";
    }
}
