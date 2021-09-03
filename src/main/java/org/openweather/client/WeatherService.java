package org.openweather.client;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;

@Log4j
public class WeatherService {

    HttpClient httpClient;

    public WeatherService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Response sendCurrentWeatherByIdAndUnitsRequest(String cityId, String units) {
        String url = new UrlBuilder()
                .currentUri()
                .cityId(cityId)
                .units(units)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameAndCountryCodeRequest(String cityName, String countryCode) {
        String url = new UrlBuilder()
                .currentUri()
                .cityName(cityName)
                .countryCode(countryCode)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameCountryCodeAndUnitsRequest(String cityName, String countryCode, String units) {
        String url = new UrlBuilder()
                .currentUri()
                .cityName(cityName)
                .countryCode(countryCode)
                .units(units)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameModeAndUnitsRequest(String cityName, String mode, String units) {
        String url = new UrlBuilder()
                .currentUri()
                .cityName(cityName)
                .mode(mode)
                .units(units)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameAndUnitRequest(String cityName, String units) {
        String url = new UrlBuilder()
                .currentUri()
                .cityName(cityName)
                .units(units)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityName(String cityName) {
        String url = new UrlBuilder()
                .currentUri()
                .cityName(cityName)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameXml(String cityName, String mode) {
        String url = new UrlBuilder()
                .currentUri()
                .cityName(cityName)
                .mode(mode)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendFiveDaysWeatherByCityIdAndUnitsRequest(String cityId, String units) {
        String url = new UrlBuilder()
                .forecastUri()
                .cityId(cityId)
                .units(units)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }

    public Response sendFiveDaysWeatherByCityNameAndUnitsRequest(String cityName, String units) {
        String url = new UrlBuilder()
                .forecastUri()
                .cityName(cityName)
                .units(units)
                .build();
        log.info("Get response by URL: " + url);
        return httpClient.getResponse(url);
    }
}