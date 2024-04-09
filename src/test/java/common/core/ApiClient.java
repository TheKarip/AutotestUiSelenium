package common.core;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static common.core.properties.Properties.API_URL;
import static common.core.properties.Properties.TOKEN;
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
                .setBaseUri(System.getProperty(API_URL))
                .addHeader("Authorization", "Bearer " + System.getProperty(TOKEN))
                .addHeader("X-GitHub-Api-Version", "2022-11-28")
                .addFilter(new AllureRestAssured())
                .build();
        return this;
    }

    public ApiClient setBody(Object body) {
        requestSpecBuilder.setBody(body);
        return this;
    }
}
