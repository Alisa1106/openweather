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
public class List {
    private int dt;
    private Main main;
    private java.util.List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private double pop;
    private Rain rain;
    private System sys;
    @JsonProperty("dt_txt")
    private String dateTxt;
}