package org.gismeteo.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openweather.utils.Waiters;

@Log4j
public class Homepage extends BasePage {

    public static final String HOMEPAGE_URL = "https://www.gismeteo.by/";
    public static final String SEARCH_DROPDOWN_ELEMENT_XPATH = "//*[@id='js-search-list']/descendant::*[@class='founditem__link']//*[text()='%s']";

    @FindBy(id = "js-search")
    WebElement searchCityField;
    Waiters waiters = new Waiters(driver);

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @Step("Open homepage")
    public Homepage openPage() {
        super.openPage(HOMEPAGE_URL);
        return this;
    }

    public Homepage waitForPageLoaded() {
        waiters.waitForPageLoaded();
        return this;
    }

    @Step("Write city name {cityName} in city field and click this name in city dropdown")
    public TodayPage selectCity(String cityName) {
        log.info(String.format("Write city name: '%s' in search field", cityName));
        searchCityField.sendKeys(cityName);
        String cityDropdownFirstLink = String.format(SEARCH_DROPDOWN_ELEMENT_XPATH, cityName);
        waiters.waitForElementLocated(By.xpath(cityDropdownFirstLink), 5);
        log.info(String.format("Select city name: '%s' from dropdown", cityName));
        driver.findElement(By.xpath(cityDropdownFirstLink)).click();
        return new TodayPage(driver);
    }
}