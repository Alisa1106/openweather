package org.openweather.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpClient {

    String baseUri;

    public HttpClient(String baseUri) {
        this.baseUri = baseUri;
    }

    public Response getResponse(String uri) {
        RestAssured.baseURI = baseUri;
        return RestAssured
                .when()
                .get(uri)
                .andReturn();
    }
}