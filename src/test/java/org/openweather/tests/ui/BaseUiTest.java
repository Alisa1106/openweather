package org.openweather.tests.ui;

import lombok.extern.log4j.Log4j;
import org.gismeteo.drivers.*;
import org.gismeteo.steps.CityWeatherSteps;
import org.gismeteo.steps.GeneralMenuSteps;
import org.openqa.selenium.WebDriver;
import org.openweather.constants.ITestData;
import org.openweather.utils.TestListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Log4j
@Listeners(TestListener.class)
public class BaseUiTest implements ITestData {

    WebDriver driver;
    CityWeatherSteps cityWeatherSteps;
    GeneralMenuSteps generalMenuSteps;

    @BeforeMethod
    public void initTest(ITestContext context) {
        driver = DriverCreator.create().createDriver();
        driver.manage().window().maximize();
        initSteps();
        String variable = "driver";
        log.debug("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        log.debug("Close browser");
        driver.quit();
    }

    public void initSteps() {
        cityWeatherSteps = new CityWeatherSteps(driver);
        generalMenuSteps = new GeneralMenuSteps(driver);
    }
}