package com.fluig.junit5.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PasswordValidatorMsourceTest {

    PasswordValidator validator = new PasswordValidator();

    @DisplayName("hasSpaces")
    @ParameterizedTest(name = "\"{0}\": {1}")
    @MethodSource("hasSpacesParamsProvider")
    void testHasSpaces(String param, boolean result) {
        assertEquals(result, validator.hasSpaces(param));
    }

    static Stream<Arguments> hasSpacesParamsProvider() {
        return Stream.of(
                Arguments.of("''", false),
                Arguments.of("ABC", false),
                Arguments.of("A", false),
                Arguments.of("A B", true),
                Arguments.of("ABC ", true),
                Arguments.of("ABCD", false)
        );
    }


}
