package org.gismeteo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.gismeteo.pages.Homepage;
import org.gismeteo.pages.WeatherInBrestPage;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openweather.utils.TestListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Log4j
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    public Homepage homepage;
    WeatherInBrestPage weatherInBrestPage;

    @BeforeMethod
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver();
        } catch (SessionNotCreatedException e) {
            log.fatal("ERROR: Chromedriver is not started. " + e.getMessage());
        }
        driver.manage().window().maximize();
        initPages();
        String variable = "driver";
        log.debug("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        log.debug("Close browser");
        driver.quit();
    }

    public void initPages() {
        homepage = new Homepage(driver);
        weatherInBrestPage = new WeatherInBrestPage(driver);
    }
}