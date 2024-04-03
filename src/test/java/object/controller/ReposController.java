package object.controller;

import common.core.ApiClient;
import object.pojo.Repository;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.POST;

public class ReposController {

    private final static String CREATE_REPO = "/user/repos";
    private final static String DELETE_REPO = "/repos/{owner}/{repo}";

    public void createPublicRepository(Repository repository) {
        new ApiClient().setBody(repository).build().
                sendRequest(POST, 201, CREATE_REPO)
                .then().log().all();
    }

    public void deleteRepositoryHasName(String owner, String repoName) {
        new ApiClient().build().sendRequest(DELETE, 204,
                DELETE_REPO, owner, repoName)
                .then().log().all();
    }

}
