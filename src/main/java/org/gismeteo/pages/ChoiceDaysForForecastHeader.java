package org.gismeteo.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class ChoiceDaysForForecastHeader extends TodayPage {

    public ChoiceDaysForForecastHeader(WebDriver driver) {
        super(driver);
    }

    public static final String TOP_BUTTONS_XPATH = "//*[contains(@class,'subnav_item')]//*[contains(text(),'%s')]";

    @FindBy(xpath = "//section//h1")
    WebElement title;

    @Step("Click button {buttonName}")
    public void clickTopButton(String buttonName) {
        String topButton = String.format(TOP_BUTTONS_XPATH, buttonName);
        waiters.waitForElementLocated(By.xpath(topButton), 5);
        log.info(String.format("Click button '%s'", buttonName));
        driver.findElement(By.xpath(topButton)).click();
    }

    public Object goToNewPage(String buttonName) {
        clickTopButton(buttonName);
        Object pageObject = new Object();
        switch (buttonName) {
            case "Сейчас":
                pageObject = new NowPage(driver);
                break;
            case "Сегодня":
                pageObject = new TodayPage(driver);
                break;
            case "Завтра":
                pageObject = new TomorrowPage(driver);
                break;
            case "3 дня":
                pageObject = new ThreeDaysPage(driver);
                break;
            case "10 дней":
                pageObject = new TenDaysPage(driver);
                break;
            case "2 недели":
                pageObject = new TwoWeeksPage(driver);
                break;
            case "Месяц":
                pageObject = new MonthPage(driver);
                break;
        }
        return pageObject;
    }

    public String getTitle() {
        return title.getText();
    }
}