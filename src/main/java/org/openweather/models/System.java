package org.openweather.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class System {
    private String country;
    private long sunrise;
    private long sunset;
    private String pod;
}