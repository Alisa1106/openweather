package org.gismeteo.drivers;

import org.gismeteo.utils.Properties;

public class DriverCreator {

    public static WebDriverCreator create() {
        switch (new Properties().getBrowser()) {
            case "firefox":
                return new FirefoxDriverCreator();
            case "remote":
                return new RemoteDriverCreator();
            default:
                return new ChromeDriverCreator();
        }
    }
}