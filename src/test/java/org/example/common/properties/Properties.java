package org.example.common.properties;

public class Properties {

    public static final String EMAIL = PropertiesLoader.get("user.email");
    public static final String PASS = PropertiesLoader.get("user.password");
    public static final String TOKEN = PropertiesLoader.get("user.token");

    public static final String API_URL = PropertiesLoader.get("api.url");
    public static final String HOME_PAGE_URL = PropertiesLoader.get("base.url");


}
