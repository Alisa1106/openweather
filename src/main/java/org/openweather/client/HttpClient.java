package org.openweather.client;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;

@Log4j
public class HttpClient {

    String baseUri;

    public HttpClient(String baseUri) {
        this.baseUri = baseUri;
    }

    @Step("Get response by URL: {uri}")
    public Response getResponse(String uri) {
        RestAssured.baseURI = baseUri;
        log.info("Get response by URL: " + uri);
        return RestAssured
                .when()
                .get(uri)
                .andReturn();
    }
}