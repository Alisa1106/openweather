package org.openweather.helper;

import io.restassured.response.Response;
import org.openweather.models.Current;
import org.openweather.utils.DateFormatter;
import org.openweather.utils.NodeListBuilder;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class WeatherToCompareConverter {

    public static WeatherToCompare convertFromJson(Current current) {
        DateFormatter dateFormatter = new DateFormatter();
        WeatherToCompare weatherToCompare = new WeatherToCompare();
        weatherToCompare.setLongitude(current.getCoordinates().getLongitude());
        weatherToCompare.setLatitude(current.getCoordinates().getLatitude());
        weatherToCompare.setSunrise(dateFormatter.getDate(1000 * (current.getSystem().getSunrise() - current.getTimezone())));
        weatherToCompare.setSunset(dateFormatter.getDate(1000 * (current.getSystem().getSunset() - current.getTimezone())));
        weatherToCompare.setWindSpeed(current.getWind().getSpeed());
        weatherToCompare.setTemperatureFeelsLike(current.getMain().getFeelsLike());
        weatherToCompare.setTemperatureMin(current.getMain().getTemperatureMin());
        weatherToCompare.setTemperatureMax(current.getMain().getTemperatureMax());
        weatherToCompare.setPressure(current.getMain().getPressure());
        weatherToCompare.setTimezone(current.getTimezone());
        return weatherToCompare;
    }

    public static WeatherToCompare convertFromXml(Response response) {
        WeatherToCompare weatherToCompare = new WeatherToCompare();
        NodeListBuilder nodeListBuilder = new NodeListBuilder();
        try {
            NodeList coordinates = nodeListBuilder.getNodeList(response, "coord");
            NodeList system = nodeListBuilder.getNodeList(response, "sun");
            NodeList wind = nodeListBuilder.getNodeList(response, "speed");
            NodeList feelsLike = nodeListBuilder.getNodeList(response, "feels_like");
            NodeList temperature = nodeListBuilder.getNodeList(response, "temperature");
            NodeList pressure = nodeListBuilder.getNodeList(response, "pressure");
            NodeList timeZone = nodeListBuilder.getNodeList(response, "timezone");

            weatherToCompare.setLongitude(coordinates.item(0).getAttributes().getNamedItem("lon").getNodeValue());
            weatherToCompare.setLatitude(coordinates.item(0).getAttributes().getNamedItem("lat").getNodeValue());
            weatherToCompare.setSunrise(system.item(0).getAttributes().getNamedItem("rise").getNodeValue());
            weatherToCompare.setSunset(system.item(0).getAttributes().getNamedItem("set").getNodeValue());
            weatherToCompare.setWindSpeed(Double.parseDouble(wind.item(0).getAttributes().getNamedItem("value").getNodeValue()));
            weatherToCompare.setTemperatureFeelsLike(Double.parseDouble(feelsLike.item(0).getAttributes().getNamedItem("value").getNodeValue()));
            weatherToCompare.setTemperatureMin(Double.parseDouble(temperature.item(0).getAttributes().getNamedItem("min").getNodeValue()));
            weatherToCompare.setTemperatureMax(Double.parseDouble(temperature.item(0).getAttributes().getNamedItem("max").getNodeValue()));
            weatherToCompare.setPressure(Double.parseDouble(((pressure.item(0).getAttributes().getNamedItem("value").getNodeValue()))));
            weatherToCompare.setTimezone(Integer.parseInt(timeZone.item(0).getTextContent()));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return weatherToCompare;
    }
}