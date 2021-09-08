package org.openweather.tests.current_weather;

import org.openweather.tests.BaseTest;
import org.openweather.utils.DocumentBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ByCityNameWithUnitsTest extends BaseTest {

    public static final String BREST_CITY_NAME = "Brest";
    public static final String XML_MODE = "xml";
    public static final String CELSIUS_UNITS = "metric";

    @Test(description = "Check status code in current weather response by Brest city name, XML mode and Celsius units")
    public void checkStatusCodeTest() {
        Assert.assertEquals(weatherService.sendCurrentWeatherByCityNameModeAndUnitsRequest(BREST_CITY_NAME, XML_MODE, CELSIUS_UNITS)
                .getStatusCode(), 200);
    }

    @Test(description = "Check header in current weather response by Brest city name, XML mode and Celsius units")
    public void checkResponseHeaderTest() {
        String contentTypeHeader = weatherService.sendCurrentWeatherByCityNameModeAndUnitsRequest(BREST_CITY_NAME, XML_MODE, CELSIUS_UNITS)
                .getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/xml; charset=utf-8");
    }

    @Test(description = "Check body in current weather response by Brest city name, XML mode and Celsius units")
    public void checkResponseBodyTest() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = new DocumentBuilder();
        NodeList nodeList = documentBuilder.getDocument(weatherService.sendCurrentWeatherByCityNameModeAndUnitsRequest
                (BREST_CITY_NAME, XML_MODE, CELSIUS_UNITS).asString()).getElementsByTagName("city");
        Assert.assertEquals(nodeList.item(0).getAttributes().getNamedItem("name").getNodeValue(), "Brest");
    }
}