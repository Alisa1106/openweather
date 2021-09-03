package org.openweather.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyReader {
    private static InputStream inputStream;

    private static String getCorrectPath(String fileName) {
        return "/" + fileName + ".properties";
    }

    public static Properties readProperties(String fileName) {
        Properties properties = new Properties();
        try {
            inputStream = PropertyReader.class.getResourceAsStream(getCorrectPath(fileName));
            if (inputStream != null)
                properties.load(inputStream);
        } catch (Exception ex) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
