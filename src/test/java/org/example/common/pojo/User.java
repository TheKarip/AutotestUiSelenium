package org.example.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class User {
    private String login;
    private String url;
    private String email;
    @JsonProperty("repos_url")
    private String reposUrl;
}
