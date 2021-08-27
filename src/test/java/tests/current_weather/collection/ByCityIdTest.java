package tests.current_weather.collection;

import adapters.Adapter;
import models.Current;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.GetResponseBody;
import utils.PropertyReader;

public class ByCityIdTest extends BaseTest {

    Adapter adapter = new Adapter();
    GetResponseBody getBody = new GetResponseBody();
    public static final String BY_CITY_ID_URI = "/weather?id=629634&appid=" + PropertyReader.getProperty("api_key") + "&units=imperial";

    @Test
    public void checkStatusCodeTest() {
        Assert.assertEquals(adapter.getResponse(BY_CITY_ID_URI).getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeaderTest() {
        String contentTypeHeader = adapter.getResponse(BY_CITY_ID_URI).getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBodyTest() {
        Current current = getBody.getResponseBody(BY_CITY_ID_URI).as(Current.class);
        Assert.assertEquals(current.getName(), "Brest");
    }
}