package org.openweather.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Clouds {
    private int all;
}