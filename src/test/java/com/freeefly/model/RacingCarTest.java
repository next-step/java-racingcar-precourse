package com.freeefly.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @DisplayName("전진이 가능하면 proceedCount 가 1 증가해야 한다")
    @Test
    void testProceed() {
        RacingCar car = new RacingCar("test");
        car.proceed(true);
        assertEquals(1, car.getProceedCount());
    }

    @DisplayName("현재 proceedCount 가 승자의 proceedCount 와 같으면 승자로 간주한다")
    @Test
    void testWinner() {
        RacingCar car = new RacingCar("test");
        car.proceed(true);
        car.proceed(true);
        car.winBy(2);
        assertTrue(car.isWinner());
    }
}