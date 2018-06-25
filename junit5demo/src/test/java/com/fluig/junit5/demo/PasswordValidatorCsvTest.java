package com.fluig.junit5.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PasswordValidatorCsvTest {

    PasswordValidator validator = new PasswordValidator();

    @DisplayName("hasSpaces")
    @ParameterizedTest(name = "\"{0}\": {1}")
    @CsvSource({"'',FALSE", "ABC,FALSE", "A,FALSE", "A B,TRUE", "'ABC ',TRUE", "ABCD,FALSE"})
    void testHasSpaces(String param, boolean result) {
        assertEquals(result, validator.hasSpaces(param));
    }
}
