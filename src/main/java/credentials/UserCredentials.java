package credentials;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

import static common.properties.Properties.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCredentials {
    private String email;
    private String password;

    public static UserCredentials getCorrectUserData() {
        return UserCredentials.builder()
                .email(System.getProperty(EMAIL))
                .password(System.getProperty(PASS))
                .build();
    }

    public static Stream<UserCredentials> getIncorrectUserData() {
        return Stream.of(
              UserCredentials.builder().email(System.getProperty(EMAIL)).password(System.getProperty(INCORRECT_PASS)).build(),
                UserCredentials.builder().email(System.getProperty(INCORRECT_EMAIL)).password(System.getProperty(INCORRECT_EMAIL)).build()
        );
    }

}
