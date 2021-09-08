package org.openweather.tests.current_weather.collection;

import org.openweather.models.Current;
import org.openweather.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByCityNameAndCountryCodeTest extends BaseTest {

    public static final String BREST_CITY_NAME = "Brest";
    public static final String BELARUS_COUNTRY_CODE = "112";

    @Test(description = "Check status code in current weather response by Brest city name and Belarus country code")
    public void checkStatusCodeTest() {
        Assert.assertEquals(weatherService.sendCurrentWeatherByCityNameAndCountryCodeRequest(BREST_CITY_NAME, BELARUS_COUNTRY_CODE)
                .getStatusCode(), 200);
    }

    @Test(description = "Check header in current weather response by Brest city name and Belarus country code")
    public void checkResponseHeaderTest() {
        String contentTypeHeader = weatherService.sendCurrentWeatherByCityNameAndCountryCodeRequest(BREST_CITY_NAME, BELARUS_COUNTRY_CODE)
                .getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test(description = "Check body in current weather response by Brest city name and Belarus country code")
    public void checkResponseBodyTest() {
        Current current = weatherService.sendCurrentWeatherByCityNameAndCountryCodeRequest(BREST_CITY_NAME, BELARUS_COUNTRY_CODE)
                .getBody().as(Current.class);
        Assert.assertEquals(current.getName(), "Brest");
    }
}