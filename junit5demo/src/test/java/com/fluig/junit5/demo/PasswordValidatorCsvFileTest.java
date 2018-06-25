package com.fluig.junit5.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class PasswordValidatorCsvFileTest {

    PasswordValidator validator = new PasswordValidator();

    @DisplayName("hasSpaces")
    @ParameterizedTest(name = "\"{0}\": {1}")
    @CsvFileSource(resources = "/test.csv")
    void testHasSpaces(String param, boolean result) {
        assertEquals(result, validator.hasSpaces(param));
    }
}
