package com.ggktech.sangam.utilites;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by Yerram Naveen Kumar on 22-11-2015.
 */
public class Utilites {


//    public static Calendar startTimeCalendar = Calendar.getInstance();
//    public static Calendar endTimeCalendar= Calendar.getInstance();


    public static String startTime = "Start Time";



    public static int hours =Utilites.currentHour();
    public static int minutes = Utilites.currentMinute();

    public static Calendar startTaskTotalWord;
    public static Calendar endTaskTotalWord;


    public static String defaultDate() {



        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return  String.valueOf(day) + "-" + String.valueOf(month + 1)+ "-" + String.valueOf(year);
    }

    public static int currentHour(){
        final Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int currentMinute(){
        final Calendar c = Calendar.getInstance();
        return c.get(Calendar.MINUTE);
    }

    public static final int getColor(Context context, int id) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return  ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
    }

    public static String msToString(long ms) {
        String hour = "";
        String min = "";
        String sec="";
        long seconds, minutes, hours;
        seconds = ms / 1000;
        minutes = seconds / 60;
        seconds = seconds % 60;
        hours = minutes / 60;
        minutes = minutes % 60;
        if(minutes<=9){
            min="0"+minutes;
        }else{
            min=minutes+"";
        }

        if(seconds<=9){
            sec = "0"+seconds;
        }else{
            sec =seconds+"";
        }
        if(hours<=9){
            hour = "0"+hours;
        }else{
            hour = hours+"";
        }

//        return(hour + ":" + min + ":" + sec);
        return(hour + ":" + min );
    }
}