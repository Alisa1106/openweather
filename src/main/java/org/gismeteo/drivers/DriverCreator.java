package org.gismeteo.drivers;

import org.gismeteo.utils.Properties;

public class DriverCreator {

    public static WebDriverCreator create() {
<<<<<<< HEAD
        switch (new Properties().getBrowser()) {
=======
        String browser = new Properties().getBrowser();
        switch (browser) {
>>>>>>> a028bac (Fixed)
            case "firefox":
                return new FirefoxDriverCreator();
            case "remote":
                return new RemoteDriverCreator();
            default:
                return new ChromeDriverCreator();
        }
    }
}