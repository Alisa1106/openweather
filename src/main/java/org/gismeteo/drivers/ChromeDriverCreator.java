package org.gismeteo.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Log4j
public class ChromeDriverCreator implements WebDriverCreator {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        try {
            return new ChromeDriver();
        } catch (SessionNotCreatedException e) {
            log.fatal("ERROR: ChromeDriver is not started. " + e.getMessage());
        }
        return null;
    }
}