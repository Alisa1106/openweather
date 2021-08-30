package org.openweather.client;

import io.restassured.response.Response;
import org.openweather.utils.PropertyReader;

public class WeatherService {

    HttpClient httpClient;

    public WeatherService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Response sendCurrentWeatherByIdAndUnitsRequest(String cityId, String units) {
        String url = "/weather?id=" + cityId + "&appid=" + PropertyReader.getProperty("api_key") + "&units=" + units;
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameAndCountryCodeRequest(String cityName, String countryCode) {
        String url = "/weather?q=" + cityName + ", " + countryCode + "&appid=" + PropertyReader.getProperty("api_key");
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameCountryCodeAndUnitsRequest(String cityName, String countryCode, String units) {
        String url = "/weather?q=" + cityName + ", " + countryCode + "&appid=" + PropertyReader.getProperty("api_key") + "&units=" + units;
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameModeAndUnitsRequest(String cityName, String mode, String units) {
        String url = "/weather?q=" + cityName + "&appid=" + PropertyReader.getProperty("api_key") + "&mode=" + mode + "&units=" + units;
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameAndUnitRequest(String cityName, String units) {
        String url = "/weather?q=" + cityName + "&appid=" + PropertyReader.getProperty("api_key") + "&units=" + units;
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityName(String cityName) {
        String url = "/weather?q=" + cityName + "&appid=" + PropertyReader.getProperty("api_key");
        return httpClient.getResponse(url);
    }

    public Response sendCurrentWeatherByCityNameXml(String cityName, String mode) {
        String url = "/weather?q=" + cityName + "&appid=" + PropertyReader.getProperty("api_key") + "&mode=" + mode;
        return httpClient.getResponse(url);
    }

    public Response sendFiveDaysWeatherByCityIdAndUnitsRequest(String cityId, String units) {
        String url = "/forecast?id=" + cityId + "&appid=" + PropertyReader.getProperty("api_key") + "&units=" + units;
        return httpClient.getResponse(url);
    }

    public Response sendFiveDaysWeatherByCityNameAndUnitsRequest(String cityName, String units) {
        String url = "/forecast?q=" + cityName + "&appid=" + PropertyReader.getProperty("api_key") + "&units=" + units;
        return httpClient.getResponse(url);
    }
}