package org.gismeteo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Actions {

    public static void moveToElement(WebDriver driver, String locator) {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
    }
}
