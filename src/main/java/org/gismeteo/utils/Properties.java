package org.gismeteo.utils;

import lombok.Data;
import org.openweather.utils.PropertyReader;

@Data
public class Properties {

    private String browser;

    public Properties() {
        java.util.Properties commonProps = PropertyReader.readProperties("common");
        browser = commonProps.getProperty("browser");
    }
}