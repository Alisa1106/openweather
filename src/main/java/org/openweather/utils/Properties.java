package org.openweather.utils;

import lombok.Data;

@Data
public class Properties {

    private String baseUrl;
    private String apiKey;
    private String cityId;

    public Properties() {
        String env = EnvironmentHandler.getEnv();
        java.util.Properties envProps = PropertyReader.readProperties(env);
        java.util.Properties commonProps = PropertyReader.readProperties("common");
        baseUrl = envProps.getProperty("weather.service.url");
        apiKey = envProps.getProperty("api.key");
        cityId = commonProps.getProperty("city.id");
    }
}