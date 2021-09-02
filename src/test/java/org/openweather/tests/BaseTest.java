package org.openweather.tests;

import org.openweather.client.HttpClient;
import org.openweather.client.WeatherService;
import org.openweather.utils.Properties;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    HttpClient httpClient;
    protected WeatherService weatherService;

    @BeforeClass
    public void initTest() {
        httpClient = new HttpClient(new Properties().getBaseUrl());
        weatherService = new WeatherService(httpClient);
    }
}