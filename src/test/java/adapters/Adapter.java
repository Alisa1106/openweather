package adapters;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Adapter {

    public Response getResponse(String uri) {
        return RestAssured
                .when()
                .get(uri)
                .andReturn();
    }
}