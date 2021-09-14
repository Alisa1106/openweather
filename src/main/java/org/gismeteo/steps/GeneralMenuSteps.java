package org.gismeteo.steps;

import io.qameta.allure.Step;
import org.gismeteo.pages.*;
import org.gismeteo.utils.TopButtonNames;
import org.openqa.selenium.WebDriver;

public class GeneralMenuSteps {

    private final HomePage homePage;
    private final NewsPage newsPage;
    private final MenuModal menuModal;

    public GeneralMenuSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        newsPage = new NewsPage(driver);
        menuModal = new MenuModal(driver);
    }

    @Step("Go to {buttonName} page")
    public GeneralMenuSteps goToGeneralMenuPage(TopButtonNames buttonName) {
        homePage.openPage()
                .goToSitePage(buttonName);
        return this;
    }

    @Step("Go to Menu modal")
    public GeneralMenuSteps goToMenuModal() {
        newsPage.goToMenuModal();
        return this;
    }

    @Step("Check that menu modal is open")
    public boolean menuModalIsOpen() {
       return menuModal.menuModalIsOpen();
    }
}
