package org.openweather.utils;

import java.text.SimpleDateFormat;

public class DateFormatter {

    public String getDate(long date) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
    }
}