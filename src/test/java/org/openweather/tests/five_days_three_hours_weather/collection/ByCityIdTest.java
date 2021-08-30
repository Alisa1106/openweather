package org.openweather.tests.five_days_three_hours_weather.collection;

import org.openweather.models.ForecastFiveDays;
import org.openweather.models.List;
import org.openweather.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByCityIdTest extends BaseTest {

    public static final String MINSK_CITY_ID = "625144";
    public static final String CELSIUS_UNITS = "metric";

    @Test
    public void checkStatusCodeTest() {
        Assert.assertEquals(weatherService.sendFiveDaysWeatherByCityIdAndUnitsRequest(MINSK_CITY_ID, CELSIUS_UNITS).getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeaderTest() {
        String contentTypeHeader = weatherService.sendFiveDaysWeatherByCityIdAndUnitsRequest(MINSK_CITY_ID, CELSIUS_UNITS)
                .getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBodyTest() {
        ForecastFiveDays forecastFiveDays = weatherService.sendFiveDaysWeatherByCityIdAndUnitsRequest(MINSK_CITY_ID, CELSIUS_UNITS)
                .getBody().as(ForecastFiveDays.class);
        List[] lists = forecastFiveDays.getList().toArray(new List[0]);
        Assert.assertEquals(lists.length, 40);
    }
}