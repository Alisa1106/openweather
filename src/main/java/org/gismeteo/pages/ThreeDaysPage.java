package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;

public class ThreeDaysPage extends ChoiceDaysForForecastHeader {

    public ThreeDaysPage(WebDriver driver) {
        super(driver);
    }

    public ThreeDaysPage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }
}