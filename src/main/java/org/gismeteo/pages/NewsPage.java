package org.gismeteo.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j
public class NewsPage extends HomePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "text")
    WebElement allSiteButton;

    @Step("Click button 'Весь сайт'")
    public MenuModal goToMenuModal() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        log.info("Click button 'Весь сайт'");
        executor.executeScript("arguments[0].click();", allSiteButton);
        return new MenuModal(driver);
    }
}