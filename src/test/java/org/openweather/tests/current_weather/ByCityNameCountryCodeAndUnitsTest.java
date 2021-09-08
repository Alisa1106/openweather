package org.openweather.tests.current_weather;

import org.openweather.models.Current;
import org.openweather.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByCityNameCountryCodeAndUnitsTest extends BaseTest {

    public static final String LOS_ANGELES_CITY_NAME = "Los Angeles";
    public static final String USA_COUNTRY_CODE = "840";
    public static final String CELSIUS_UNITS = "metric";

    @Test(description = "Check status code in current weather response by Los Angeles city name, USA country code and Celsius units")
    public void checkStatusCodeTest() {
        Assert.assertEquals(weatherService.sendCurrentWeatherByCityNameCountryCodeAndUnitsRequest(LOS_ANGELES_CITY_NAME, USA_COUNTRY_CODE,
                CELSIUS_UNITS).getStatusCode(), 200);
    }

    @Test(description = "Check header in current weather response by Los Angeles city name, USA country code and Celsius units")
    public void checkResponseHeaderTest() {
        String contentTypeHeader = weatherService.sendCurrentWeatherByCityNameCountryCodeAndUnitsRequest(LOS_ANGELES_CITY_NAME, USA_COUNTRY_CODE,
                CELSIUS_UNITS).getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test(description = "Check body in current weather response by Los Angeles city name, USA country code and Celsius units")
    public void checkResponseBodyTest() {
        Current current = weatherService.sendCurrentWeatherByCityNameCountryCodeAndUnitsRequest(LOS_ANGELES_CITY_NAME, USA_COUNTRY_CODE,
                CELSIUS_UNITS).getBody().as(Current.class);
        Assert.assertEquals(current.getName(), "Los Angeles");
        Assert.assertEquals(current.getSystem().getCountry(), "US");
    }
}