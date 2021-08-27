package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rain {
    @SerializedName("1h")
    private double inHour;
    @SerializedName("3h")
    private double inThreeHours;
}