package org.openweather.tests.ui;

import org.openweather.constants.IConstants;
import org.openweather.utils.TestParameter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UiCommonTest extends BaseUiTest implements IConstants {

    @Test(dataProvider = "Buttons and pages", dataProviderClass = TestParameter.class, description = "Verify forecast by city header buttons")
    public void forecastHeaderButtonsTest(String buttonName, String pageTitle) {
        cityWeatherSteps
                .goToTodayPage(BREST_CITY_NAME_RU)
                .goToForecastPage(buttonName);
        Assert.assertEquals(cityWeatherSteps.getTitle(), pageTitle);
    }
}