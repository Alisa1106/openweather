package org.openweather.helper;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.openweather.models.Current;
import org.openweather.utils.DateFormatter;
import org.openweather.utils.NodeListBuilder;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Log4j
public class WeatherToCompareConverter {

    public static WeatherToCompare convertFromJson(Current current) {
        DateFormatter dateFormatter = new DateFormatter();
//        log.info("Build object from JSON response");
        return new WeatherToCompare.Builder()
                .longitude(current.getCoordinates().getLongitude())
                .latitude(current.getCoordinates().getLatitude())
                .sunrise(dateFormatter.getDate(1000 * (current.getSystem().getSunrise() - current.getTimezone())))
                .sunset(dateFormatter.getDate(1000 * (current.getSystem().getSunset() - current.getTimezone())))
                .speed(current.getWind().getSpeed())
                .temperatureFeelsLike(current.getMain().getFeelsLike())
                .temperatureMin(current.getMain().getTemperatureMin())
                .temperatureMax(current.getMain().getTemperatureMax())
                .pressure(current.getMain().getPressure())
                .timezone(current.getTimezone())
                .build();
    }

    public static WeatherToCompare convertFromXml(Response response) {
        NodeListBuilder nodeListBuilder = new NodeListBuilder();
        try {
            NodeList coordinates = nodeListBuilder.getNodeList(response, "coord");
            NodeList system = nodeListBuilder.getNodeList(response, "sun");
            NodeList wind = nodeListBuilder.getNodeList(response, "speed");
            NodeList feelsLike = nodeListBuilder.getNodeList(response, "feels_like");
            NodeList temperature = nodeListBuilder.getNodeList(response, "temperature");
            NodeList pressure = nodeListBuilder.getNodeList(response, "pressure");
            NodeList timeZone = nodeListBuilder.getNodeList(response, "timezone");
//            log.info("Build object from XML response");
            return new WeatherToCompare.Builder()
                    .longitude(coordinates.item(0).getAttributes().getNamedItem("lon").getNodeValue())
                    .latitude(coordinates.item(0).getAttributes().getNamedItem("lat").getNodeValue())
                    .sunrise(system.item(0).getAttributes().getNamedItem("rise").getNodeValue())
                    .sunset(system.item(0).getAttributes().getNamedItem("set").getNodeValue())
                    .speed(Double.parseDouble(wind.item(0).getAttributes().getNamedItem("value").getNodeValue()))
                    .temperatureFeelsLike(Double.parseDouble(feelsLike.item(0).getAttributes().getNamedItem("value").getNodeValue()))
                    .temperatureMin(Double.parseDouble(temperature.item(0).getAttributes().getNamedItem("min").getNodeValue()))
                    .temperatureMax(Double.parseDouble(temperature.item(0).getAttributes().getNamedItem("max").getNodeValue()))
                    .pressure(Double.parseDouble(((pressure.item(0).getAttributes().getNamedItem("value").getNodeValue()))))
                    .timezone(Integer.parseInt(timeZone.item(0).getTextContent()))
                    .build();
        } catch (ParserConfigurationException | IOException | SAXException e) {
//            log.fatal("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}