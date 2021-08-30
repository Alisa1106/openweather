package org.openweather.tests;

import org.openweather.client.HttpClient;
import org.openweather.client.WeatherService;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    HttpClient httpClient;
    protected WeatherService weatherService;

    @BeforeTest
    public void initTest() {
        String weatherApiBaseUri = "http://api.openweathermap.org/data/2.5";
        httpClient = new HttpClient(weatherApiBaseUri);
        weatherService = new WeatherService(httpClient);
    }
}