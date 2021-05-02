package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void init() {
        car = new RacingCar("grace");
    }

    @Test
    @DisplayName("자동")
    void createCarNameTest() {

        final String name = car.getName();

        assertThat(name).isNotNull();
    }
}
