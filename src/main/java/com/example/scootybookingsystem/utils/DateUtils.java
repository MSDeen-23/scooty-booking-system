package com.example.scootybookingsystem.utils;

import java.sql.Timestamp;

public class DateUtils {

    public static Long getCurrentTime(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
}
