package org.example.common.controller;

import lombok.extern.java.Log;
import org.example.common.ApiClient;
import org.example.common.pojo.Repository;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.POST;

@Log
public class ReposController {

    private final static String CREATE_REPO = "/user/repos";
    private final static String DELETE_REPO = "/repos/{owner}/{repo}";

    public void createPublicRepository(Repository repository) {
        log.info("Request: create repository");
        new ApiClient().setBody(repository).build().
                sendRequest(POST, 201, CREATE_REPO);
    }

    public void deleteRepositoryHasName(String owner, String repoName) {
        log.info("Request: delete repository");
        new ApiClient().build().sendRequest(DELETE, 204,
                DELETE_REPO, owner, repoName);
    }

}
