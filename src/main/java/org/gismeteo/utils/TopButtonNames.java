package org.gismeteo.utils;

import lombok.Getter;

@Getter
public enum TopButtonNames {

    WEATHER("Погода"),
    NEWS("Новости"),
    MAPS("Карты"),
    INFORMERS("Информеры"),
    APPS("Приложения");

    String name;

    TopButtonNames(String name) {
        this.name = name;
    }
}