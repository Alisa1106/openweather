package org.gismeteo.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.gismeteo.utils.MediumButtonNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class ChoiceDaysForForecastHeader extends BasePage {

    public ChoiceDaysForForecastHeader(WebDriver driver) {
        super(driver);
    }

    public static final String MIDDLE_BUTTONS_XPATH = "//*[contains(@class,'subnav_item')]//*[contains(text(),'%s')]";

    @FindBy(xpath = "//section//h1")
    WebElement title;

    @Step("Click button {buttonName}")
    public void clickMediumButton(String buttonName) {
        String mediumButton = String.format(MIDDLE_BUTTONS_XPATH, buttonName);
        waiters.waitForElementLocated(By.xpath(mediumButton), 5);
        log.info(String.format("Click button '%s'", buttonName));
        driver.findElement(By.xpath(mediumButton)).click();
    }

    public Object goToForecastPage(MediumButtonNames buttonName) {
        clickMediumButton(buttonName.getName());
        Object pageObject = new Object();
        switch (buttonName) {
            case NOW:
                pageObject = new NowPage(driver);
                break;
            case TODAY:
                pageObject = new TodayPage(driver);
                break;
            case TOMORROW:
                pageObject = new TomorrowPage(driver);
                break;
            case THREE_DAYS:
                pageObject = new ThreeDaysPage(driver);
                break;
            case TEN_DAYS:
                pageObject = new TenDaysPage(driver);
                break;
            case TWO_WEEKS:
                pageObject = new TwoWeeksPage(driver);
                break;
            case MONTH:
                pageObject = new MonthPage(driver);
                break;
            default:
                log.error("Invalid enum");
        }
        return pageObject;
    }

    public String getTitle() {
        return title.getText();
    }
}