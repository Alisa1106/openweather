package org.openweather.utils;

import lombok.extern.log4j.Log4j;

import java.text.SimpleDateFormat;

@Log4j
public class DateFormatter {

    public String getDate(long date) {
        log.info("Get correct format for date: " + date);
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
    }
}