package org.example.common.properties;

import static org.example.common.properties.PropertiesLoader.get;

public class Properties {

    public static final String EMAIL = get("user.email");
    public static final String PASS = get("user.password");
    public static final String TOKEN = get("user.token");

    public static final String API_URL = get("api.url");
    public static final String HOME_PAGE_URL = get("base.url");

    public static final String BROWSER = get("browser");

    public static final int TIMEOUT = Integer.parseInt(get("timeout"));
}
