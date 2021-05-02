package com.game.global.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerUtilsTest {

    @DisplayName("0 에서 9 사이의 랜덤한 정수 생성 테스트")
    @Test
    public void getRandomSingleNumberTest() {
        // Given & When
        final Integer randomSingleNumber = IntegerUtils.getRandomSingleNumber();

        // Then
        Assertions.assertTrue(0 <= randomSingleNumber && randomSingleNumber <= 9);
    }

}
