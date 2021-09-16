package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;

public class MonthPage extends ChoiceDaysForForecastHeader {

    public MonthPage(WebDriver driver) {
        super(driver);
    }

    public MonthPage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }
}