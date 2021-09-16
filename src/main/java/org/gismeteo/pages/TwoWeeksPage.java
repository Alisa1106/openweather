package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;

public class TwoWeeksPage extends ChoiceDaysForForecastHeader {

    public TwoWeeksPage(WebDriver driver) {
        super(driver);
    }

    public TwoWeeksPage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }
}