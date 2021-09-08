package org.openweather.tests.current_weather.collection;

import org.openweather.models.Current;
import org.openweather.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByCityIdTest extends BaseTest {

    public static final String BREST_CITY_ID = "629634";
    public static final String FAHRENHEIT_UNITS = "imperial";

    @Test(description = "Check status code in current weather response by Brest city name and Fahrenheit units")
    public void checkStatusCodeTest() {
        Assert.assertEquals(weatherService.sendCurrentWeatherByIdAndUnitsRequest(BREST_CITY_ID, FAHRENHEIT_UNITS)
                .getStatusCode(), 200);
    }

    @Test(description = "Check header in current weather response by Brest city name and Fahrenheit units")
    public void checkResponseHeaderTest() {
        String contentTypeHeader = weatherService.sendCurrentWeatherByIdAndUnitsRequest(BREST_CITY_ID, FAHRENHEIT_UNITS).getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test(description = "Check body in current weather response by Brest city name and Fahrenheit units")
    public void checkResponseBodyTest() {
        Current current = weatherService.sendCurrentWeatherByIdAndUnitsRequest(BREST_CITY_ID, FAHRENHEIT_UNITS).getBody().as(Current.class);
        Assert.assertEquals(current.getName(), "Brest");
    }
}