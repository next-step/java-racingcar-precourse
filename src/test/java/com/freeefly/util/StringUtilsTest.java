package com.freeefly.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @DisplayName("전달받은 파라미터만큼의 -를 이어서 리턴해야 한다")
    @Test
    void testGetIterableDashes() {
        int count = 5;
        String iterableDashes = StringUtils.getIterableDashes(count);
        assertEquals("-----", iterableDashes);
    }
}