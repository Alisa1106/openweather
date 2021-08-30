package org.openweather.utils;

import io.restassured.response.Response;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class NodeListBuilder {

    DocumentBuilder documentBuilder = new DocumentBuilder();

    public NodeList getNodeList(Response response, String tagName) throws ParserConfigurationException, IOException, SAXException {
        return documentBuilder.getDocument(response.asString()).getElementsByTagName(tagName);
    }
}