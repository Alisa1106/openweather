package org.gismeteo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuModal extends NewsPage {

    public MenuModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "modal-menu")
    WebElement menuModal;

    public boolean menuModalIsOpen() {
        return menuModal.isDisplayed();
    }
}