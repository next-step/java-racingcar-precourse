package com.ktc2.precourse.racingcar.converter;

import static org.junit.jupiter.api.Assertions.*;

import com.ktc2.precourse.racingcar.exception.NotIntegerException;
import com.ktc2.precourse.racingcar.exception.NotPositiveIntegerException;
import com.ktc2.precourse.racingcar.model.DtoAttemptsNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptsNumberConverterTest {

    Converter<String, DtoAttemptsNumber> converter;

    @BeforeEach
    void setUp() {
        converter = new AttemptsNumberConverter();
    }

    @Test
    @DisplayName("올바른 케이스에 대해 변환이 잘 되는지 여부 테스트")
    void validStringTest() {
        assertEquals(new DtoAttemptsNumber(1), converter.convertOrThrow("0001"));
        for (int i = 1; i <= 1000; i++) {
            assertEquals(new DtoAttemptsNumber(i), converter.convertOrThrow(String.valueOf(i)));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { ",", "$", "hello", "a,b", "5u", "k1", " 23", "4 9", "4u8", "3.1", "4e5", "0x32", "0b101" })
    @DisplayName("정수 형식이 아닌 문자열에 대해 예외가 발생하는지 테스트")
    void invalidIntegerTest(String input) {
        assertThrows(NotIntegerException.class, () -> converter.convertOrThrow(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "0", "000", "-1", "-1023" })
    @DisplayName("양의 정수 형식이 아닌 문자열에 대해 예외가 발생하는지 테스트")
    void invalidPositiveIntegerTest(String input) {
        assertThrows(NotPositiveIntegerException.class, () -> converter.convertOrThrow(input));
    }
}