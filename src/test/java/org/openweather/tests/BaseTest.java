package org.openweather.tests;

import lombok.extern.log4j.Log4j;
import org.openweather.client.HttpClient;
import org.openweather.client.WeatherService;
import org.openweather.utils.Properties;
import org.openweather.utils.ServiceLogger;
import org.openweather.utils.TestListener;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Log4j
@Listeners(TestListener.class)
public class BaseTest {

    HttpClient httpClient;
    protected WeatherService weatherService;

//    @BeforeSuite
//    public void initLogger() {
//        ServiceLogger.createLogger();
//    }

    @BeforeMethod
    public void initTest(ITestContext context) {
        log.info("Create new http client");
        httpClient = new HttpClient(new Properties().getBaseUrl());
        log.info("Create new weather service");
        weatherService = new WeatherService(httpClient);
    }
}