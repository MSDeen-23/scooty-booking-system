package com.example.scootybookingsystem.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StrategyUtils {


    public static int calculateMinutes(long startTime,long endTime){
        long diff =endTime - startTime;
        long diffMinutes = diff / (60 * 1000) % 60;
        return (int) diffMinutes;


    }
    public static int calculatePrice(long startTime,long endTime, int pricePerHour){
        long minutes =calculateMinutes(startTime,endTime);
        return (int) (minutes* pricePerHour/60);
    }
}
