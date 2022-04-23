package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingOrganizerTest {

    @Test
    void 초과_글자_입력시_IllegalArgumentException() {
        // given
        String names = "hama,pobi,honux,kyungrae";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> RacingOrganizer.createCars(names));
    }
}
