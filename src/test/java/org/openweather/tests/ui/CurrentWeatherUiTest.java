package org.openweather.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.LocalTime;

public class CurrentWeatherUiTest extends BaseUiTest {

    @Test(description = "Verify to currentTemperature less than 30 celsius degrees")
    public void currentTodayTemperatureTest() {
        cityWeatherSteps.goToTodayPage(BREST_CITY_NAME_RU);
        Assert.assertTrue(cityWeatherSteps.getCurrentTemperatureAtTodayPage() < 30);
    }

    @Test(description = "Verify to current time displays correct")
    public void currentTimeTest() {
        cityWeatherSteps.goToTodayPage(BREST_CITY_NAME_RU);
        Assert.assertEquals(cityWeatherSteps.getCurrentTime(), Time.valueOf(LocalTime.now()).toString().substring(0, 5));
    }

    @Test(description = "Verify to current temperature at current page match current temperature at now page")
    public void currentNowTemperatureTest() {
        cityWeatherSteps.goToTodayPage(BREST_CITY_NAME_RU);
        double currentTemperature = cityWeatherSteps.getCurrentTemperatureAtTodayPage();
        Assert.assertEquals(cityWeatherSteps.goToForecastPage(NOW_BUTTON_NAME).getCurrentTemperatureAtNowPage(), currentTemperature);
    }
}