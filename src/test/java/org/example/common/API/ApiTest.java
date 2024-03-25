package org.example.common.API;

import org.example.common.ApiClient;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.POST;
import static org.example.common.Const.OWNER;
import static org.example.common.Const.REPO_NAME;

public class ApiTest {

    private final static String CREATE_REPO = "/user/repos";
    private final static String DELETE_REPO = String.format("/repos/%s/%s", OWNER, REPO_NAME);

    private final ApiClient apiClient = new ApiClient();

    @Test
    public void createPublicRepository() {
        Map<String, String> param = new HashMap<>();
        param.put("name", REPO_NAME);
        param.put("description", "Created with assured API");

        apiClient.setBody(param).build().
                sendRequest(POST,201, CREATE_REPO);
    }

    @Test
    public void deleteRepositoryHasName() {
        apiClient.build().sendRequest(DELETE,204, DELETE_REPO);
    }
}
