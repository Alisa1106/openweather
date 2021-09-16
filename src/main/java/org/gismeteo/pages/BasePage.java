package org.gismeteo.pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.gismeteo.utils.Waiters;

@Log4j
public class BasePage {

    WebDriver driver;
    Waiters waiters;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        log.info(String.format("Open URL: '%s'", url));
        driver.get(url);
    }
}