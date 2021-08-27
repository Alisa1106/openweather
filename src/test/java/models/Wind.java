package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Wind {
    private double speed;
    private int deg;
    private double gust;
}