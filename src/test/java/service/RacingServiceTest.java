package service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class RacingServiceTest {
    private final RacingService racingService = new RacingService();

    @Test
    void testCreateCars() {
        // given
        String input = "pobi, woni,jun, pobi";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] result = {"pobi", "woni", "jun"};

        // when
        String[] list = racingService.createCars();

        // then
        assertArrayEquals(list, result);
    }
    @Test
    void testInputRacingCount1() {
        // given
        String input = "12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = 12;

        // when
        int count = racingService.inputRacingCount();

        // then
        assertEquals(count, result);
    }

    @Test
    void testInputRacingCount2() {
        // given
        String input = "-1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when // then
        assertThrows(IllegalArgumentException.class, racingService::inputRacingCount);
    }

    @Test
    void testInputRacingCount3() {
        // given
        String input = "asd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when // then
        assertThrows(IllegalArgumentException.class, racingService::inputRacingCount);
    }
}