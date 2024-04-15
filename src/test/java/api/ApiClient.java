package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static common.properties.Properties.API_URL;
import static common.properties.Properties.TOKEN;

public class ApiClient {

    private final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    private RequestSpecification requestSpecification;


    public Response sendRequest(Method method, int expectedStatusCode, String path, Object... params) {
        return RestAssured.given()
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
