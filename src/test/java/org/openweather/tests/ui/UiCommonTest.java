package org.openweather.tests.ui;

import org.gismeteo.utils.MediumButtonNames;
import org.gismeteo.utils.TestParameter;
import org.gismeteo.utils.TopButtonNames;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UiCommonTest extends BaseUiTest {

    @Test(dataProvider = "Buttons and pages", dataProviderClass = TestParameter.class, description = "Verify forecast by city header buttons")
    public void forecastHeaderButtonsTest(MediumButtonNames buttonName, String pageTitle) {
        cityWeatherSteps
                .goToTodayPage(BREST_CITY_NAME_RU)
                .goToForecastPage(buttonName);
        Assert.assertEquals(cityWeatherSteps.getTitle(), pageTitle);
    }

    @Test(description = "Verify that menu modal is open")
    public void NewsModalTest() {
        generalMenuSteps
                .goToGeneralMenuPage(TopButtonNames.NEWS)
                .goToMenuModal();
        Assert.assertTrue(generalMenuSteps.menuModalIsOpen());
    }
}