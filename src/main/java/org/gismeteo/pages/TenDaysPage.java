package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;

public class TenDaysPage extends ChoiceDaysForForecastHeader {

    public TenDaysPage(WebDriver driver) {
        super(driver);
    }

    public TenDaysPage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }
}