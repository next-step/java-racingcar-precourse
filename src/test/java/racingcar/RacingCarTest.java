package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(new Name("hello"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("난수 4이상이 입력되었을 경우 자동차는 한칸 전진한다.")
    void move(int random) {
        // when
        racingCar.moveForward(random);
        int travelDistance = racingCar.getTravelDistance();

        // then
        assertThat(travelDistance).isOne();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("난수 3이하가 입력되었을 경우 자동차는 이동하지 않는다.")
    void stop(int random) {
        // when
        racingCar.moveForward(random);
        int travelDistance = racingCar.getTravelDistance();

        // then
        assertThat(travelDistance).isZero();
    }
}