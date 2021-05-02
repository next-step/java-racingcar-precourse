package com.game.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {
    @Test
    @DisplayName("랜덤 숫자(0~9) 생성 테스트")
    public void getRandomNumberTest() {
        // given
        int startNumber = 0;
        int endNumber = 9;

        // when
        int randomNumber = RandomUtil.getRandomNumber(startNumber, endNumber);
        System.out.println("randomNumber = " + randomNumber);

        // then
        assertThat(randomNumber).isBetween(startNumber, endNumber);
    }
}