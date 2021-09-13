package org.openweather.tests.api.five_days_three_hours_weather;

import org.openweather.models.ForecastFiveDays;
import org.openweather.tests.api.BaseApiTest;
import org.gismeteo.utils.TestParameter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class fiveDaysForecastForCitiesApiTest extends BaseApiTest {

    @Test(dataProvider = "Cities", dataProviderClass = TestParameter.class, description = "Check that in forecast 5 days temperature feels like " +
            "at 15.00 less than 35 degrees")
    void feelsLikeAtThreeAmTest(String cityName) {
        ForecastFiveDays forecastFiveDays = weatherService.sendFiveDaysWeatherByCityNameAndUnitsRequest(cityName, CELSIUS_UNITS).getBody().as(ForecastFiveDays.class);
        List<org.openweather.models.List> listWeatherAtThreeAm = forecastFiveDays.getList().stream().filter(list -> list.getDateTxt()
                .contains("15:00:00")).collect(Collectors.toList());
        for (org.openweather.models.List element : listWeatherAtThreeAm) {
            Assert.assertTrue(element.getMain().getFeelsLike() < 35);
        }
    }
}