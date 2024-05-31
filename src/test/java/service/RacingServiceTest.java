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

        // when
        String[] list = racingService.createCars();
        String[] result = {"pobi", "woni", "jun"};

        // then
        assertArrayEquals(list, result);
    }
}