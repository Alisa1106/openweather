package org.openweather.tests.api.five_days_three_hours_weather;

import org.openweather.constants.ITestData;
import org.openweather.models.ForecastFiveDays;
import org.openweather.models.List;
import org.openweather.tests.api.BaseApiTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByCityNameApiTest extends BaseApiTest {

    @Test(description = "Check status code in forecast 5 days 3 hours weather response by Brest city name and Celsius units")
    public void checkStatusCodeTest() {
        Assert.assertEquals(weatherService.sendFiveDaysWeatherByCityNameAndUnitsRequest(BREST_CITY_NAME_ENG, CELSIUS_UNITS)
                .getStatusCode(), 200);
    }

    @Test(description = "Check header in forecast 5 days 3 hours weather response by Brest city name and Celsius units")
    public void checkResponseHeaderTest() {
        String contentTypeHeader = weatherService.sendFiveDaysWeatherByCityNameAndUnitsRequest(BREST_CITY_NAME_ENG, CELSIUS_UNITS)
                .getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test(description = "Check body in forecast 5 days 3 hours weather response by Brest city name and Celsius units")
    public void checkResponseBodyTest() {
        ForecastFiveDays forecastFiveDays = weatherService.sendFiveDaysWeatherByCityNameAndUnitsRequest(BREST_CITY_NAME_ENG, CELSIUS_UNITS)
                .as(ForecastFiveDays.class);
        List[] lists = forecastFiveDays.getList().toArray(new List[0]);
        Assert.assertEquals(lists.length, 40);
    }
}