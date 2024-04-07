package tests.credentials;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

import static common.core.properties.Properties.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCredentials {
    private String email;
    private String password;

    public static UserCredentials getCorrectUserData() {
        return UserCredentials.builder()
                .email(EMAIL)
                .password(PASS)
                .build();
    }

    public static Stream<UserCredentials> getIncorrectUserData() {
        return Stream.of(
              UserCredentials.builder().email(EMAIL).password(INCORRECT_PASS).build(),
                UserCredentials.builder().email(INCORRECT_EMAIL).password(INCORRECT_PASS).build()
        );
    }

}
