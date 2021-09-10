package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;

public class TomorrowPage extends ChoiceDaysForForecastHeader {

    public TomorrowPage(WebDriver driver) {
        super(driver);
    }

    public TomorrowPage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }
}