package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
    }
}