package org.gismeteo.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.gismeteo.utils.TopButtonNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class HomePage extends BasePage {

    public static final String HOMEPAGE_URL = "https://www.gismeteo.by/";
    public static final String SEARCH_DROPDOWN_ELEMENT_XPATH = "//*[@id='js-search-list']/descendant::*[@class='founditem__link']//*[text()='%s']";
    public static final String TOP_BUTTONS_XPATH = "//*[@class='nav_item']//*[contains(text(),'%s')]";

    @FindBy(id = "js-search")
    WebElement searchCityField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open homepage")
    public HomePage openPage() {
        super.openPage(HOMEPAGE_URL);
        return this;
    }

    public HomePage waitForPageLoaded() {
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

    @Step("Click button {buttonName}")
    public void clickTopButton(String buttonName) {
        String topButton = String.format(TOP_BUTTONS_XPATH, buttonName);
        waiters.waitForElementLocated(By.xpath(topButton), 5);
        log.info(String.format("Click button '%s'", buttonName));
        driver.findElement(By.xpath(topButton)).click();
    }

    public Object goToSitePage(TopButtonNames buttonName) {
        clickTopButton(buttonName.getName());
        Object pageObject = new Object();
        switch (buttonName) {
            case WEATHER:
                pageObject = new WeatherPage(driver);
                break;
            case NEWS:
                pageObject = new NewsPage(driver);
                break;
            case MAPS:
                pageObject = new MapsPage(driver);
                break;
            case INFORMERS:
                pageObject = new InformersPage(driver);
                break;
            case APPS:
                pageObject = new AppsPage(driver);
                break;
            default:
                log.error("Invalid enum");
        }
        return pageObject;
    }
}