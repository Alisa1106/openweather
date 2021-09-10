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

    @DataProvider(name = "Buttons and pages")
    static Object[][] buttons() {
        return new Object[][]{
                {"Сейчас", "Погода в Бресте сейчас"},
                {"Сегодня", "Погода в Бресте"},
                {"Завтра", "Погода в Бресте на завтра"},
                {"3 дня", "Погода в Бресте на 3 дня"},
                {"10 дней", "Погода в Бресте на 10 дней"},
                {"2 недели", "Погода в Бресте на две недели"},
                {"Месяц", "Погода в Бресте на месяц"}
        };
    }
}