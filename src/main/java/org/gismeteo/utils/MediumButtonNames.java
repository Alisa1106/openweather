package org.gismeteo.utils;

import lombok.Getter;

@Getter
public enum MediumButtonNames {

    NOW("Сейчас"),
    TODAY("Сегодня"),
    TOMORROW("Завтра"),
    THREE_DAYS("3 дня"),
    TEN_DAYS("10 дней"),
    TWO_WEEKS("2 недели"),
    MONTH("Месяц");

    String name;

    MediumButtonNames(String name) {
        this.name = name;
    }
}