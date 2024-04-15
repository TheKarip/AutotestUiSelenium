package api.controller;

import api.ApiClient;
import io.restassured.http.Method;
import object.pojo.Repository;
import object.pojo.User;

import java.util.List;

public class UserController {

    private static final String GET_USER_PATH = "/user";

    public List<Repository> getRepositoryList() {
        return new ApiClient().build().sendRequest(Method.GET, 200, getUserData().getReposUrl())
                .getBody().jsonPath().getList("", Repository.class);
    }

    public User getUserData() {
        return new ApiClient().build().sendRequest(Method.GET, 200,
                GET_USER_PATH).as(User.class);
    }
}
