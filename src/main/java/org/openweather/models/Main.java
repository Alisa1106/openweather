package org.openweather.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Main {
    @SerializedName("temp")
    private double temperature;
    @SerializedName("feels_like")
    private double feelsLike;
    @SerializedName("temp_min")
    private double temperatureMin;
    @SerializedName("temp_max")
    private double temperatureMax;
    private int pressure;
    private int humidity;
    @SerializedName("sea_level")
    private int seaLevel;
    @SerializedName("grnd_level")
    private int groundLevel;
    @SerializedName("temp_kf")
    private double tempKf;
}