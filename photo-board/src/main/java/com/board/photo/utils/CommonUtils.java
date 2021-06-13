package com.board.photo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtils {
    public static String getUniqueId() {
        String uniqueId = "";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Calendar dateTime = Calendar.getInstance();
        uniqueId = sdf.format(dateTime.getTime());
            
        //yyyymmddhh24missSSS_랜덤문자6개
        uniqueId = uniqueId + RandomStringUtils.randomAlphanumeric(6);

        return uniqueId;
    }
}
