package com.freeefly.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameTest {

    @DisplayName("게임 생성 시 생성자에 null 인 parameter 가 들어가면 AssertException 을 일으킨다")
    @Test
    void testIsValidGame() {
        assertThrows(AssertionError.class, () -> new RacingGame(null, null, null));
    }



}