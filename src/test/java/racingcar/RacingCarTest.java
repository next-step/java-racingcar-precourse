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
    @DisplayName("자동차 생성시 이름을 가지고 있는지 테스트")
    void createCarNameTest() {

        final String name = car.getName();

        assertThat(name).isNotNull();
    }

    @Test
    @DisplayName("자동차 생성시 전진횟수를 가지고 있는지 테스트")
    void createCarNumberOfAdvancesTest() {

        final int numberOfAdvances = car.getNumberOfAdvances();

        assertThat(numberOfAdvances).isNotNull();
    }
}
