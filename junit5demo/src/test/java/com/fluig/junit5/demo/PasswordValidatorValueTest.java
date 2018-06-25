package com.fluig.junit5.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordValidatorValueTest {

    PasswordValidator validator = new PasswordValidator();

    @ParameterizedTest(name = "\"{0}\" doesnt have spaces")
    @ValueSource(strings = {"", "A", "ABC"})
    void testHasSpaces_FALSE(String param) {
        assertFalse(validator.hasSpaces(param));
    }

    @ParameterizedTest(name = "\"{0}\" has spaces")
    @ValueSource(strings = {"A C", "ABC ", "  "})
    void testHasSpaces_TRUE(String param) {
        assertTrue(validator.hasSpaces(param));
    }

}
