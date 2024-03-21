package org.example.common;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.example.common.Const.*;

public class ArgumentsForTest {

    static public Stream<Arguments> getArgumentsForLoginTest() {
        return Stream.of(
                Arguments.of(INCORRECT_EMAIL, PASS),
                Arguments.of(EMAIL, INCORRECT_PASS),
                Arguments.of(INCORRECT_EMAIL, INCORRECT_PASS)
        );
    }
}
