package utils;

import adapters.Adapter;
import io.restassured.response.ResponseBody;

public class GetResponseBody {

    Adapter adapter = new Adapter();

    public ResponseBody<?> getResponseBody(String uri) {
        return (ResponseBody<?>) adapter.getResponse(uri).getBody();
    }
}