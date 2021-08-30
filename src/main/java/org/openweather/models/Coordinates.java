package org.openweather.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coordinates {
    @SerializedName("lon")
    private String longitude;
    @SerializedName("lat")
    private String latitude;
}