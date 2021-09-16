package org.gismeteo.pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class TodayPage extends ChoiceDaysForForecastHeader {

    public TodayPage(WebDriver driver) {
        super(driver);
    }

    public static final String WEATHER_PARAMETER_WIDGET_XPATH = "//*[contains(@data-widget-id,'%s')]";
    public static final String CURRENT_DATE_AND_WEEKDAY_XPATH = WEATHER_PARAMETER_WIDGET_XPATH + "//*[contains(@class,'widget__datelink')]";

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

    public TodayPage moveToWidget(String widgetName) {
        String widget = String.format(WEATHER_PARAMETER_WIDGET_XPATH, widgetName);
        waiters.waitForElementLocated(By.xpath(widget), 5);
        org.gismeteo.utils.Actions.moveToElement(driver, widget);
        return this;
    }

    public String getCurrentDateAndWeekDay(String widgetName, String widgetHeader) {
        log.info(String.format("Move to widget: '%s'", widgetHeader));
        moveToWidget(widgetName);
        return driver.findElement(By.xpath(String.format(CURRENT_DATE_AND_WEEKDAY_XPATH, widgetName))).getText();
    }
}