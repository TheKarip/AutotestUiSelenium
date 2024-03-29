package org.example.common.controller;

import org.example.common.ApiClient;
import org.example.common.pojo.Repository;
import org.example.common.pojo.User;

import java.util.List;

import static io.restassured.http.Method.GET;


public class UserController {

    private static final String GET_USER_PATH = "/user";

    public List<Repository> getRepositoryList() {
        return new ApiClient().build().sendRequest(GET, 200, getUserData().getReposUrl())
                .getBody().jsonPath().getList("", Repository.class);
    }

    public User getUserData() {
        return new ApiClient().build().sendRequest(GET, 200,
                GET_USER_PATH).as(User.class);
    }
}
