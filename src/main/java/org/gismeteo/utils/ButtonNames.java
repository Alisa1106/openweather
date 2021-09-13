package org.gismeteo.utils;

public enum ButtonNames {

    NOW("Сейчас"),
    TODAY("Сегодня"),
    TOMORROW("Завтра"),
    THREE_DAYS("3 дня"),
    TEN_DAYS("10 дней"),
    TWO_WEEKS("2 недели"),
    MONTH("Месяц");

    String name;

    ButtonNames(String name) {
        this.name = name;
    }
}