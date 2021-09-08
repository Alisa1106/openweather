package org.openweather.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
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
    private Object WeatherToCompare;

    public WeatherToCompare() {

    }

    public static class Builder {

        private WeatherToCompare weatherToCompare;

        public Builder() {
            weatherToCompare = new WeatherToCompare();
        }

        public Builder longitude(String longitude) {
            weatherToCompare.longitude = longitude;
            return this;
        }

        public Builder latitude(String latitude) {
            weatherToCompare.latitude = latitude;
            return this;
        }

        public Builder sunrise(String sunrise) {
            weatherToCompare.sunrise = sunrise;
            return this;
        }

        public Builder sunset(String sunset) {
            weatherToCompare.sunset = sunset;
            return this;
        }

        public Builder speed(double windSpeed) {
            weatherToCompare.windSpeed = windSpeed;
            return this;
        }

        public Builder temperatureFeelsLike(double temperatureFeelsLike) {
            weatherToCompare.temperatureFeelsLike = temperatureFeelsLike;
            return this;
        }

        public Builder temperatureMin(double temperatureMin) {
            weatherToCompare.temperatureMin = temperatureMin;
            return this;
        }

        public Builder temperatureMax(double temperatureMax) {
            weatherToCompare.temperatureMax = temperatureMax;
            return this;
        }

        public Builder pressure(double pressure) {
            weatherToCompare.pressure = pressure;
            return this;
        }

        public Builder timezone(int timezone) {
            weatherToCompare.timezone = timezone;
            return this;
        }

        public WeatherToCompare build() {
            return weatherToCompare;
        }
    }
}