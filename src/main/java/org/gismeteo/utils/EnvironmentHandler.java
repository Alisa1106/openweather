package org.gismeteo.utils;

public class EnvironmentHandler {

    public static final String MY_BROWSER_ENV = "MY_BROW";
    public static final String DEFAULT_BROWSER = "chrome";

    public static String getBrowserEnv() {
        String env = System.getenv().getOrDefault(MY_BROWSER_ENV, DEFAULT_BROWSER);
        switch (env) {
            case "firefox":
                return BrowserEnv.FIREFOX.name();
            case "remote":
                return BrowserEnv.REMOTE.name();
            default:
                return BrowserEnv.CHROME.name();
        }
    }
}
