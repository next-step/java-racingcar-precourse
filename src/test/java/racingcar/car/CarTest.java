package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.move.Movement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("차 생성")
    public void create_car() {
        String carName = "GV70";
        int defaultPosition = 0;
        Car car = new Car(carName);
        CarName name = car.getCarName();
        CarPosition position = car.getPosition();
        assertThat(name.getName()).isEqualTo(carName);
        assertThat(position.getPosition()).isEqualTo(defaultPosition);
    }

    @DisplayName("차 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"777777", "   "})
    public void failed_car(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이동(전진)")
    public void go_car() {
        Car car = new Car("test");
        Movement goMovement = initMovement(true);
        car.move(goMovement);
        CarPosition carPosition = car.getPosition();
        assertThat(carPosition.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동(stop)")
    public void stop_car() {
        Car car = new Car("test");
        Movement stopMovement = initMovement(false);
        car.move(stopMovement);
        CarPosition carPosition = car.getPosition();
        assertThat(carPosition.getPosition()).isEqualTo(0);
    }

    private Movement initMovement(boolean isMove) {
        return new Movement() {
            @Override
            public boolean isMoveAble() {
                return isMove;
            }

            @Override
            public int getIncreasePosition(int position) {
                return 1;
            }
        };
    }


}
