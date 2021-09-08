package org.openweather.tests.current_weather.task;

import org.openweather.helper.WeatherToCompareConverter;
import org.openweather.models.Current;
import org.openweather.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrentWeatherForBrestTest extends BaseTest {

    public static final String BREST_CITY_NAME = "Brest";
    public static final String CELSIUS_UNITS = "metric";
    public static final String XML_MODE = "xml";
    public static final double CELSIUS_AND_KELVIN_DIFFERENCE = 273.15;

    @Test(description = "Check that temperature by Celsius match temperature by Kelvin in responses")
    public void weatherByUnitsTest() {
        Current currentCelsius = weatherService.sendCurrentWeatherByCityNameAndUnitRequest(BREST_CITY_NAME, CELSIUS_UNITS).getBody().as(Current.class);
        double tempCelsius = currentCelsius.getMain().getTemperature();
        Current currentKelvin = weatherService.sendCurrentWeatherByCityName(BREST_CITY_NAME).as(Current.class);
        double tempKelvin = currentKelvin.getMain().getTemperature();
        Assert.assertEquals(tempKelvin, tempCelsius + CELSIUS_AND_KELVIN_DIFFERENCE);
    }

    @Test(description = "Check that object from JSON response equals object from XML response")
    public void weatherByXmlAndJsonTest() {
        Current current = weatherService.sendCurrentWeatherByCityName(BREST_CITY_NAME).getBody().as(Current.class);
        Assert.assertEquals(WeatherToCompareConverter.convertFromJson(current), WeatherToCompareConverter
                .convertFromXml(weatherService.sendCurrentWeatherByCityNameXml(BREST_CITY_NAME, XML_MODE)));
    }
}