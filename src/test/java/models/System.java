package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class System {
    private String country;
    private int sunrise;
    private int sunset;
    private String pod;
}