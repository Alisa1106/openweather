package org.openweather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    @JsonProperty("temp")
    private double temperature;
    @JsonProperty("feels_like")
    private double feelsLike;
    @JsonProperty("temp_min")
    private double temperatureMin;
    @JsonProperty("temp_max")
    private double temperatureMax;
    private int pressure;
    private int humidity;
    @JsonProperty("sea_level")
    private int seaLevel;
    @JsonProperty("grnd_level")
    private int groundLevel;
    @JsonProperty("temp_kf")
    private double tempKf;
}