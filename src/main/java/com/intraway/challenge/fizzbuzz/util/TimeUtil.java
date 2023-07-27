package com.intraway.challenge.fizzbuzz.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeUtil {

    public static long localDateTimeToMillis(LocalDateTime time){
        return Timestamp.valueOf(time).toInstant().toEpochMilli();
    }
}
