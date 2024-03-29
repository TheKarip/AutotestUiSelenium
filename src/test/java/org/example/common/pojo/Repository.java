package org.example.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    private String name;
    private String isPrivate;

    public Repository(String name, String isPrivate) {
        this.name = name;
        this.isPrivate = isPrivate;
    }

    public Repository() {
    }

    public String getName() {
        return name;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }
}