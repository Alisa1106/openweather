package tests.five_days_three_hours_weather.collection;

import adapters.Adapter;
import models.ForecastFiveDays;
import models.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.GetResponseBody;
import utils.PropertyReader;

public class ByCityNameTest extends BaseTest {

    Adapter adapter = new Adapter();
    GetResponseBody getBody = new GetResponseBody();
    public static final String BY_CITY_NAME_URI =
            "/forecast?q=Brest&appid=" + PropertyReader.getProperty("api_key") + "&units=metric";

    @Test
    public void checkStatusCodeTest() {

        Assert.assertEquals(adapter.getResponse(BY_CITY_NAME_URI).getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeaderTest() {
        String contentTypeHeader = adapter.getResponse(BY_CITY_NAME_URI).getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBodyTest() {
        ForecastFiveDays forecastFiveDays = getBody.getResponseBody(BY_CITY_NAME_URI).as(ForecastFiveDays.class);
        List[] lists = forecastFiveDays.getList().toArray(new List[0]);
        Assert.assertEquals(lists.length, 40);
    }
}