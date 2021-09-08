package org.gismeteo.tests;

import org.testng.annotations.Test;

public class BrestCurrentWeatherTest extends BaseTest {

    @Test
    public void currentTemperatureTest() {
        homepage.openPage()
                .selectCity("Брест");
    }
}