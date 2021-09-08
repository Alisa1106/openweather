package org.gismeteo.pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class Homepage extends BasePage {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public static final String HOMEPAGE_URL = "https://www.gismeteo.by/";
    public static final String SEARCH_DROPDOWN_ELEMENT_XPATH = "//*[@id='js-search-list']//*[text()='%s']";

    @FindBy(id = "js-search")
    WebElement searchCityField;

    public Homepage openPage() {
        super.openPage(HOMEPAGE_URL);
        return this;
    }

    public WeatherInBrestPage selectCity(String cityName) {
        log.info(String.format("Write city name: '%s' in search field", cityName));
        searchCityField.sendKeys(cityName);
        log.info(String.format("Select city name: '%s' from dropdown", cityName));
        driver.findElement(By.xpath(String.format(SEARCH_DROPDOWN_ELEMENT_XPATH, cityName))).click();
        return new WeatherInBrestPage(driver);
    }
}