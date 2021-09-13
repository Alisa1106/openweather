package org.gismeteo.utils;

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
                {ButtonNames.NOW.name, "Погода в Бресте сейчас"},
                {ButtonNames.TODAY.name, "Погода в Бресте"},
                {ButtonNames.TOMORROW.name, "Погода в Бресте на завтра"},
                {ButtonNames.THREE_DAYS.name, "Погода в Бресте на 3 дня"},
                {ButtonNames.TEN_DAYS.name, "Погода в Бресте на 10 дней"},
                {ButtonNames.TWO_WEEKS.name, "Погода в Бресте на две недели"},
                {ButtonNames.MONTH.name, "Погода в Бресте на месяц"}
        };
    }
}