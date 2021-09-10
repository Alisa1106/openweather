package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openweather.utils.Waiters;

public class TodayPage extends BasePage {

    public TodayPage(WebDriver driver) {
        super(driver);
    }

    Waiters waiters = new Waiters(driver);

    @FindBy(xpath = "//*[contains(@class,'unit_temperature_c')]//*[contains(@class,'js_value')]")
    WebElement currentTemperatureCelsius;

    @FindBy(xpath = "//*[@id='time']")
    WebElement currentTimeElement;

    public TodayPage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }

    public double getCurrentTemperature() {
        String currentWeather = currentTemperatureCelsius.getText().replace("+", "").replace(",", ".");
        return Double.parseDouble(currentWeather.trim());
    }

    public String getCurrentTime() {
        waiters.waitForElementLocated(currentTimeElement, 5);
        String currentTime = currentTimeElement.getText();
        if (currentTime.length() == 4) {
            currentTime = "0" + currentTime;
        }
        return currentTime;
    }
}