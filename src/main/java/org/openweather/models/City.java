package org.openweather.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {
    private int id;
    private String name;
    @SerializedName("coord")
    private Coordinates coordinates;
    private String country;
    private int population;
    private int timezone;
    private int sunrise;
    private int sunset;
}