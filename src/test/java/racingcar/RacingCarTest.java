package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void validationRacingCarNameTest() {
        assertThatThrownBy( () -> {
            RacingCar racing = new RacingCar("pobi,woni,pobi");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
