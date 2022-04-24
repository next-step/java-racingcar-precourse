package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("움직이는차");
    }

    @Test
    @DisplayName("숫자의 값이 4이상일경우 전진 3이하일 경우 멈춘다")
    void moveStatus4OverRunElseStop() {
        int moveCommand = 4;
        int stopCommand = 3;
        assertThat(MoveStatus.MOVE).isEqualTo(car.command(moveCommand));
        assertThat(MoveStatus.STOP).isEqualTo(car.command(stopCommand));
        assertThat(MoveStatus.MOVE).isEqualTo(car.command(moveCommand));
        assertThat(car.getPosition()).isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("숫자의 값은 0 ~ 9 만 가능하다.")
    void moveStatusCommandIs0_9() {
        car.command(9);
        assertThatIllegalArgumentException().isThrownBy(() -> car.command(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> car.command(10));
    }

    @Test
    @DisplayName("차이름이 같으면 같은 차이다")
    void equalCar() {
        assertThat(new Car("자동차")).isEqualTo(new Car("자동차"));
        assertThat(new Car("자동차")).isNotEqualTo(new Car("자동차2"));
    }

    @Test
    @DisplayName("자동차의 상태가 이름 : - 형태로 반환 된다")
    void displayCar() {
        Car car = new Car("자동차");
        assertThat(car.toString()).isEqualTo("자동차 : ");
        car.getPosition().add();
        assertThat(car.toString()).isEqualTo("자동차 : -");
    }

    @Test
    @DisplayName("자동차의 이름을 반환")
    void carName() {
        assertThat(car.getName()).isEqualTo("움직이는차");
    }

    @Test
    @DisplayName("자동차의 움직인 위치를 반환")
    void getLength() {
        assertThat(car.moveLength()).isEqualTo(0);
        car.command(4);
        assertThat(car.moveLength()).isEqualTo(1);

    }

}
