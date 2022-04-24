package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 자동차_생성(final String name) {
        assertThat(new Car(name).getName()).isEqualTo(name);
    }

    @Test
    void 자동자_전진() {
        Car car = new Car("pobi");
        car.moveCar();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"4,1", "2,0"})
    void 자동차_전진_멈춤_확인(final int moveNumber, final int positionValue) {
        Car car = new Car("pobi");
        car.judgeAndMove(moveNumber);

        assertThat(car.getPosition()).isEqualTo(positionValue);
    }

    @Test
    void 포지션값_비교() {
        Car car = new Car("pobi");
        car.moveCar();

        assertThat(car.compareHighPosition(0)).isEqualTo(car.getPosition());
    }
}