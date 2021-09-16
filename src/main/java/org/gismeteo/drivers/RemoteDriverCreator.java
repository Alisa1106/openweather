package org.gismeteo.drivers;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j
public class RemoteDriverCreator implements WebDriverCreator {
    @Override
    public WebDriver createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.fatal("ERROR: RemoteDriver is not started. " + e.getMessage());
        }
        return null;
    }
}