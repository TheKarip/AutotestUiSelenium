package api.controller;

import api.ApiClient;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import object.pojo.Repository;

public class ReposController {

    private final static String CREATE_REPO = "/user/repos";
    private final static String DELETE_REPO = "/repos/{owner}/{repo}";

    @Step("Create public repository")
    public void createPublicRepository(Repository repository) {
        new ApiClient().setBody(repository).build().
                sendRequest(Method.POST, 201, CREATE_REPO);
    }

    @Step("Delete repository")
    public void deleteRepositoryHasName(String owner, String repoName) {
        new ApiClient().build().sendRequest(Method.DELETE, 204,
                DELETE_REPO, owner, repoName);
    }

}
