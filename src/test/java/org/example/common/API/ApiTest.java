package org.example.common.API;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.example.common.Const.*;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    private final String getReposPerName = String.format("/repos/%s/%s", OWNER, REPO_NAME);
    private final String createRepos = String.format("/user/repos", OWNER);
    private ObjectMapper mapper = new ObjectMapper();

    public void createPublicRepository() {
        Map<String, String> param = new HashMap<>();
        param.put("name", REPO_NAME);
        param.put("description", "Created with assured API");

        given()
                .header("Authorization", "Bearer " + TOKEN2)
                .header("X-GitHub-Api-Version", "2022-11-28")
                .baseUri(URL)
                .when()
                .body(param)
                .post(createRepos)
                .then().log().all()
                .body("name", equalTo(REPO_NAME));

    }
}
