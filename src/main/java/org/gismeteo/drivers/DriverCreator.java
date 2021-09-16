package org.gismeteo.drivers;

import org.gismeteo.utils.Properties;

public class DriverCreator {

    public static WebDriverCreator create() {
        String browser = new Properties().getBrowser();
        switch (browser) {
            case "firefox":
                return new FirefoxDriverCreator();
            case "remote":
                return new RemoteDriverCreator();
            default:
                return new ChromeDriverCreator();
        }
    }
}