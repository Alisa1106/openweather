package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NowPage extends ChoiceDaysForForecastHeader {

    public NowPage(WebDriver driver) {
        super(driver);
    }

    public NowPage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }

    @FindBy(xpath = "//*[@class ='now__weather']//*[@class='nowvalue__text_l']")
    WebElement currentTemperatureCelsius;

    public double getCurrentTemperature() {
        String currentWeather = currentTemperatureCelsius.getText().replace("+", "").replace(",", ".");
        return Double.parseDouble(currentWeather.trim());
    }
}