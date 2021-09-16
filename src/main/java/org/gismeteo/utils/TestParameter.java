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
                {MediumButtonNames.NOW, "Погода в Бресте сейчас"},
                {MediumButtonNames.TODAY, "Погода в Бресте"},
                {MediumButtonNames.TOMORROW, "Погода в Бресте на завтра"},
                {MediumButtonNames.THREE_DAYS, "Погода в Бресте на 3 дня"},
                {MediumButtonNames.TEN_DAYS, "Погода в Бресте на 10 дней"},
                {MediumButtonNames.TWO_WEEKS, "Погода в Бресте на две недели"},
                {MediumButtonNames.MONTH, "Погода в Бресте на месяц"}
        };
    }

    @DataProvider(name = "Widgets")
    static Object[][] widgets() {
        return new Object[][]{
                {"wind", "Ветер"},
                {"roadcondition", "Погода на дорогах"},
                {"pressure", "Давление"},
                {"humidity", "Относительная влажность"},
                {"visibility", "Видимость"},
                {"sun_moon", "Солнце и Луна"},
                {"uvb", "Ультрафиолетовый индекс"},
                {"gm", "Геомагнитная активность"}
        };
    }
}