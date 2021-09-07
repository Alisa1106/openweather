package org.openweather.utils;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.*;

import java.io.IOException;

@Log4j
public class ServiceLogger {

    public static void createLogger() {
        Logger root = Logger.getRootLogger();
        try {
            FileAppender fileAppender = new RollingFileAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"),
                    "target/tests.log", false);
            fileAppender.setThreshold(Level.toLevel("DEBUG"));
            root.addAppender(fileAppender);
        } catch (IOException e) {
            log.fatal("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        ConsoleAppender consoleAppender = new ConsoleAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"));
        consoleAppender.setThreshold(Level.toLevel("INFO"));
        root.addAppender(consoleAppender);
    }
}