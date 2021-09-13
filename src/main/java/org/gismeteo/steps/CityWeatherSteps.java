package org.gismeteo.steps;

import io.qameta.allure.Step;
import org.gismeteo.pages.ChoiceDaysForForecastHeader;
import org.gismeteo.pages.NowPage;
import org.gismeteo.pages.TodayPage;
import org.gismeteo.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class CityWeatherSteps {

    private final HomePage homePage;
    private final TodayPage todayPage;
    private final NowPage nowPage;
    private final ChoiceDaysForForecastHeader choiceDaysForForecastHeader;


    public CityWeatherSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        todayPage = new TodayPage(driver);
        nowPage = new NowPage(driver);
        choiceDaysForForecastHeader = new ChoiceDaysForForecastHeader(driver);
    }

    @Step("Go to city {cityName} today forecast page")
    public CityWeatherSteps goToTodayPage(String cityName) {
        homePage.openPage()
                .waitForPageLoaded()
                .selectCity(cityName)
                .waitForPageLoaded();
        return this;
    }

    @Step("Get current temperature at today page")
    public double getCurrentTemperatureAtTodayPage() {
        return todayPage.getCurrentTemperature();
    }

    @Step("Get current temperature at now page")
    public double getCurrentTemperatureAtNowPage() {
        return nowPage.getCurrentTemperature();
    }

    @Step("Get current time")
    public String getCurrentTime() {
        return todayPage.getCurrentTime();
    }

    @Step("Go to forecast page: {buttonName}")
    public CityWeatherSteps goToForecastPage(String buttonName) {
        choiceDaysForForecastHeader.goToNewPage(buttonName);
        return this;
    }

    @Step("Get current page title")
    public String getTitle() {
        return choiceDaysForForecastHeader.getTitle();
    }
}