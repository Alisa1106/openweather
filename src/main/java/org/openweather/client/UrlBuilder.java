package org.openweather.client;

import org.openweather.utils.Properties;

public class UrlBuilder {

    private String url = "";

    public UrlBuilder() {
        url += "appid=" + new Properties().getApiKey();
    }

    public UrlBuilder currentUri() {
        url = "/weather?" + url;
        return this;
    }

    public UrlBuilder forecastUri() {
        url = "/forecast?" + url;
        return this;
    }

    public UrlBuilder cityId(String cityId) {
        url += "&id=" + cityId;
        return this;
    }

    public UrlBuilder cityName(String cityName) {
        url += "&q=" + cityName;
        return this;
    }

    public UrlBuilder countryCode(String countryCode) {
        url += ", " + countryCode;
        return this;
    }

    public UrlBuilder units(String units) {
        url += "&units=" + units;
        return this;
    }

    public UrlBuilder mode(String mode) {
        url += "&mode=" + mode;
        return this;
    }

    public String build() {
        return url;
    }
}
