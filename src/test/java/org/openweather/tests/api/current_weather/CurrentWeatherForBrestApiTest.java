package org.openweather.tests.api.current_weather;

import org.openweather.constants.ITestData;
import org.openweather.helper.WeatherToCompareConverter;
import org.openweather.models.Current;
import org.openweather.tests.api.BaseApiTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrentWeatherForBrestApiTest extends BaseApiTest {

    @Test(description = "Check that temperature by Celsius match temperature by Kelvin in responses")
    public void weatherByUnitsTest() {
        Current currentCelsius = weatherService.sendCurrentWeatherByCityNameAndUnitRequest(BREST_CITY_NAME_ENG, CELSIUS_UNITS).getBody().as(Current.class);
        double tempCelsius = currentCelsius.getMain().getTemperature();
        Current currentKelvin = weatherService.sendCurrentWeatherByCityName(BREST_CITY_NAME_ENG).as(Current.class);
        double tempKelvin = currentKelvin.getMain().getTemperature();
        Assert.assertEquals(tempKelvin, tempCelsius + CELSIUS_AND_KELVIN_DIFFERENCE);
    }

    @Test(description = "Check that object from JSON response equals object from XML response")
    public void weatherByXmlAndJsonTest() {
        Current current = weatherService.sendCurrentWeatherByCityName(BREST_CITY_NAME_ENG).getBody().as(Current.class);
        Assert.assertEquals(WeatherToCompareConverter.convertFromJson(current), WeatherToCompareConverter
                .convertFromXml(weatherService.sendCurrentWeatherByCityNameXml(BREST_CITY_NAME_ENG, XML_MODE)));
    }
}