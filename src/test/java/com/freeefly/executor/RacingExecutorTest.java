package com.freeefly.executor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingExecutorTest {
    private RacingExecutor executor;

    @BeforeEach
    public void init() {
        executor = new RacingExecutor();
    }

    @DisplayName("입력 받은 숫자가 4 이상이면 true, 아니면 false 를 리턴해야 한다")
    @Test
    void testIsProceed() {
        Integer proceedNumber1 = 2;
        Integer proceedNumber2 = 5;

        Boolean proceed1 = executor.proceed(proceedNumber1);
        Boolean proceed2 = executor.proceed(proceedNumber2);
        assertAll(
                () -> assertFalse(proceed1),
                () -> assertTrue(proceed2)
        );
    }

}