package org.gismeteo.utils;

public enum BrowserEnv {

    CHROME("chrome"),
    FIREFOX("firefox"),
    REMOTE("remote");

    String name;

    BrowserEnv(String name) {
        this.name = name;
    }
}
