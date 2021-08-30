package org.openweather.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Current {
    @SerializedName("coord")
    private Coordinates coordinates;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private int dt;
    @SerializedName("sys")
    private System system;
    private int timezone;
    private int id;
    private String name;
    private int cod;
}