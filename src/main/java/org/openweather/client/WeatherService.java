package org.openweather.client;

import io.restassured.response.Response;
import org.openweather.utils.PropertyReader;

public class WeatherService {

    HttpClient httpClient;

    public WeatherService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Response sendCurrentWeatherByIdAndUnitsRequest(String cityId, String units) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .currentUri()
                .cityId(cityId)
                .units(units)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameAndCountryCodeRequest(String cityName, String countryCode) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .currentUri()
                .cityName(cityName)
                .countryCode(countryCode)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameCountryCodeAndUnitsRequest(String cityName, String countryCode, String units) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .currentUri()
                .cityName(cityName)
                .countryCode(countryCode)
                .units(units)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameModeAndUnitsRequest(String cityName, String mode, String units) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .currentUri()
                .cityName(cityName)
                .mode(mode)
                .units(units)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameAndUnitRequest(String cityName, String units) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .currentUri()
                .cityName(cityName)
                .units(units)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityName(String cityName) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .currentUri()
                .cityName(cityName)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameXml(String cityName, String mode) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .currentUri()
                .cityName(cityName)
                .mode(mode)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendFiveDaysWeatherByCityIdAndUnitsRequest(String cityId, String units) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .forecastUri()
                .cityId(cityId)
                .units(units)
                .build();
        return httpClient.getResponse(url);
    }

    public Response sendFiveDaysWeatherByCityNameAndUnitsRequest(String cityName, String units) {
        String url = new UrlBuilder(PropertyReader.getProperty("api_key"))
                .forecastUri()
                .cityName(cityName)
                .units(units)
                .build();
        return httpClient.getResponse(url);
    }
}