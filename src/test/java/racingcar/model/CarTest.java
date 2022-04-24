package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.common.ErrorMessage.ENERGY_NOT_ACCEPTED;
import static racingcar.common.ErrorMessage.NAME_TO_LONG;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.create("pobi");
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void carTest() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 테스트")
    void carNameTooLongTest() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            car = Car.create("javajigi");
        }).withMessage(NAME_TO_LONG.text());
    }

    @Test
    @DisplayName("자동차 위치값 초기화")
    void carWithPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치값 변경")
    void carForwardPosition() {
        car.move(CarEngine.charge(3));
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(CarEngine.charge(4));
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 충전 0-9 아닌 숫자 넘기기 테스트")
    void carEnergyNotAccepted() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            car.move((CarEngine.charge(-1)));
        }).withMessage(ENERGY_NOT_ACCEPTED.text());
        assertThatIllegalArgumentException().isThrownBy(()->{
            car.move((CarEngine.charge(10)));
        }).withMessage(ENERGY_NOT_ACCEPTED.text());
    }

    @Test
    @DisplayName("자동차 위치 비교")
    void carCompare() {
        Car javaCar = Car.create("java");
        javaCar.move(CarEngine.charge(CarEngine.MINIMUM_MOVE_ENERGY));
        assertThat(javaCar.compareTo(car)).isEqualTo(1);
        assertThat(javaCar).isGreaterThan(car);
    }

}
