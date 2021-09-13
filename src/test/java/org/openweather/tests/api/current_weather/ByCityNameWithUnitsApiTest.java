package org.openweather.tests.api.current_weather;

import org.openweather.constants.ITestData;
import org.openweather.tests.api.BaseApiTest;
import org.openweather.utils.DocumentBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ByCityNameWithUnitsApiTest extends BaseApiTest {

    @Test(description = "Check status code in current weather response by Brest city name, XML mode and Celsius units")
    public void checkStatusCodeTest() {
        Assert.assertEquals(weatherService.sendCurrentWeatherByCityNameModeAndUnitsRequest(BREST_CITY_NAME_ENG, XML_MODE, CELSIUS_UNITS)
                .getStatusCode(), 200);
    }

    @Test(description = "Check header in current weather response by Brest city name, XML mode and Celsius units")
    public void checkResponseHeaderTest() {
        String contentTypeHeader = weatherService.sendCurrentWeatherByCityNameModeAndUnitsRequest(BREST_CITY_NAME_ENG, XML_MODE, CELSIUS_UNITS)
                .getHeader("Content-Type");
        Assert.assertEquals(contentTypeHeader, "application/xml; charset=utf-8");
    }

    @Test(description = "Check body in current weather response by Brest city name, XML mode and Celsius units")
    public void checkResponseBodyTest() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = new DocumentBuilder();
        NodeList nodeList = documentBuilder.getDocument(weatherService.sendCurrentWeatherByCityNameModeAndUnitsRequest
                (BREST_CITY_NAME_ENG, XML_MODE, CELSIUS_UNITS).asString()).getElementsByTagName("city");
        Assert.assertEquals(nodeList.item(0).getAttributes().getNamedItem("name").getNodeValue(), "Brest");
    }
}