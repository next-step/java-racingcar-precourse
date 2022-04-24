package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Position;
import racingcar.domain.RandomNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    private String carName1 = "jin";
    private Car car1;


    @BeforeEach
    void setUp() {
        car1 = new Car(carName1);
    }

    @Test
    @DisplayName("자동차_이동")
    void race() {
        car1.race(RandomNumber.of(7));

        assertThat(car1).isEqualTo(new Car(carName1, 1));
    }

    @Test
    @DisplayName("자동차_이동하지않음")
    void race2() {
        car1.race(RandomNumber.of(0));

        assertThat(car1).isEqualTo(new Car(carName1, 0));
    }

    @Test
    @DisplayName("더큰이동거리_반환")
    void getLargerPosition() {
        car1.race(RandomNumber.of(7));
        car1.race(RandomNumber.of(9));

        assertThat(car1.getLargerPosition(new Position(7))).isEqualTo(new Position(7));
    }

    @Test
    @DisplayName("최대거리인지확인")
    void isSamePosition() {
        car1.race(RandomNumber.of(7));

        assertThat(car1.isSamePosition(new Position(1))).isEqualTo(true);
    }
}