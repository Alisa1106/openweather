package org.openweather.utils;

import lombok.Data;

@Data
public class Properties {

    private String baseUrl;
    private String apiKey;
    public static final String MY_ENV = "qa";
    public static final String DEFAULT_ENV = "prod";
    public static final String MY_API_KEY = "api_key";
    public static final String DEFAULT_API_KEY = "api_key";

    public Properties() {
        baseUrl = System.getenv().getOrDefault(PropertyReader.getProperty(MY_ENV), PropertyReader.getProperty(DEFAULT_ENV));
        apiKey = System.getenv().getOrDefault(PropertyReader.getProperty(MY_API_KEY), PropertyReader.getProperty(DEFAULT_API_KEY));
    }
}