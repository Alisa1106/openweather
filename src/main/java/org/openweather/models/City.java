package org.openweather.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private int id;
    private String name;
    @JsonProperty("coord")
    private Coordinates coordinates;
    private String country;
    private int population;
    private int timezone;
    private int sunrise;
    private int sunset;
}