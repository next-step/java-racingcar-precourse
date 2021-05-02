package com.game.global.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CsvUtilsTest {

    @DisplayName("CSV 문자열을 문자 배열로 변환 테스트")
    @Test
    public void makeStringArrayTest() {
        // Given
        String csvString = "";

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> CsvUtils.makeStringArray(csvString));

        // Then
        Assertions.assertEquals(CsvUtils.EMPTY_CSV_STRING, exception.getMessage());
    }

}
