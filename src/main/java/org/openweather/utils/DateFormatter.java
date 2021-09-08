package org.openweather.utils;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import java.text.SimpleDateFormat;

@Log4j
public class DateFormatter {

    @Step("Get correct format for date: {date}")
    public String getDate(long date) {
        log.info("Get correct format for date: " + date);
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
    }
}