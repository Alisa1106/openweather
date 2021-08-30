package org.openweather.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WeatherToCompare {

    private String longitude;
    private String latitude;
    private String sunrise;
    private String sunset;
    private double windSpeed;
    private double temperatureFeelsLike;
    private double temperatureMin;
    private double temperatureMax;
    private double pressure;
    private int timezone;

    public WeatherToCompare() {

    }
}