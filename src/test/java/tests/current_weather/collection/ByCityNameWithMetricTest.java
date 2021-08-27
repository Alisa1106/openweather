package tests.current_weather.collection;

import adapters.Adapter;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tests.BaseTest;
import utils.DocumentBuilder;
import utils.PropertyReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ByCityNameWithMetricTest extends BaseTest {

    Adapter adapter = new Adapter();
    public static final String BY_CITY_NAME_WITH_METRIC_URI =
            "/weather?q=Brest&appid=" + PropertyReader.getProperty("api_key") + "&mode=xml&units=metric";

    @Test
    public void checkStatusCodeTest() {
        Assert.assertEquals(adapter.getResponse(BY_CITY_NAME_WITH_METRIC_URI).getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeaderTest() {
        String contentTypeHeader = adapter.getResponse(BY_CITY_NAME_WITH_METRIC_URI).getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/xml; charset=utf-8");
    }

    @Test
    public void checkResponseBodyTest() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = new DocumentBuilder();
        NodeList nodeList = documentBuilder.getDocument(adapter.getResponse(BY_CITY_NAME_WITH_METRIC_URI).asString()).getElementsByTagName("city");
        Assert.assertEquals(nodeList.item(0).getAttributes().getNamedItem("name").getNodeValue(), "Brest");
    }
}