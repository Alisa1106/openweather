package tests.current_weather.collection;

import adapters.Adapter;
import models.Current;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.GetResponseBody;
import utils.PropertyReader;

public class ByCityNameAndCountryCodeTest extends BaseTest {

    Adapter adapter = new Adapter();
    GetResponseBody getBody = new GetResponseBody();
    public static final String BY_CITY_NAME_AND_COUNTRY_CODE_URI =
            "/weather?q=Brest, 112&appid=" + PropertyReader.getProperty("api_key");

    @Test
    public void checkStatusCodeTest() {
        Assert.assertEquals(adapter.getResponse(BY_CITY_NAME_AND_COUNTRY_CODE_URI).getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeaderTest() {
        String contentTypeHeader = adapter.getResponse(BY_CITY_NAME_AND_COUNTRY_CODE_URI).getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBodyTest() {
        Current current = getBody.getResponseBody(BY_CITY_NAME_AND_COUNTRY_CODE_URI).as(Current.class);
        Assert.assertEquals(current.getName(), "Brest");
    }
}