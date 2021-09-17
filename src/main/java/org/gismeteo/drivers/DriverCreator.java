package org.gismeteo.drivers;

public class DriverCreator {

    public static WebDriverCreator create(String browser) {
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