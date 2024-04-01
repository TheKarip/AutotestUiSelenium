package common.core;

import common.core.properties.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    private RequestSpecification requestSpecification;


    public Response sendRequest(Method method, int expectedStatusCode, String path, Object... params) {
        return given()
                .spec(requestSpecification)
                .request(method, path, params)
                .then()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public ApiClient build() {
        requestSpecification = requestSpecBuilder
                .setBaseUri(Properties.API_URL)
                .addHeader("Authorization", "Bearer " + Properties.TOKEN)
                .addHeader("X-GitHub-Api-Version", "2022-11-28")
                .build();
        return this;
    }

    public ApiClient setBody(Object body) {
        requestSpecBuilder.setBody(body);
        return this;
    }
}
