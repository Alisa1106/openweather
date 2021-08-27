package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ForecastFiveDays {
    private int cod;
    private int message;
    private int cnt;
    private List<models.List> list;
}