package org.openweather.utils;

public class EnvironmentsReader {

    public static final String DEFAULT = "http://api.openweathermap.org/data/2.5";

    public static String getEnvironment(String name) {
        return System.getenv().getOrDefault(name, DEFAULT);
    }
}