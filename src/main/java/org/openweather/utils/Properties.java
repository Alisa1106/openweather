package org.openweather.utils;

import lombok.Data;

@Data
public class Properties {

    private String baseUrl;
    private String apiKey;
    public static final String MY_ENV = "qa";
    public static final String MY_API_KEY = "api_key";
    public static final String QA_ENV_FILE_NAME = "qa";
    public static final String PROD_ENV_FILE_NAME = "prod";
    public static final String API_KEY_FILE_NAME = "apikey";

    public Properties() {
        switch (MY_ENV) {
            case "qa":
                baseUrl = PropertyReader.readProperties(QA_ENV_FILE_NAME).getProperty(MY_ENV);
                apiKey = PropertyReader.readProperties(API_KEY_FILE_NAME).getProperty(MY_API_KEY);
                break;
            default:
                baseUrl = PropertyReader.readProperties(PROD_ENV_FILE_NAME).getProperty(MY_ENV);
                apiKey = PropertyReader.readProperties(API_KEY_FILE_NAME).getProperty(MY_API_KEY);
        }
    }
}