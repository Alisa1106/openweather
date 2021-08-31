package org.openweather.utils;

import org.testng.annotations.DataProvider;

public class TestParameter {

    @DataProvider(name = "Cities")
    static Object[][] cities() {
        return new Object[][]{
                {"Minsk"},
                {"Brest"},
                {"Grodno"},
                {"Vitebsk"},
                {"Mogilev"},
                {"Gomel"}
        };
    }
}