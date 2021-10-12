package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingTest {

    ArrayList<Car> carList = new ArrayList<Car>();

    @Test
    void 이동_명령_4_to_9() {
        assertThat(Racing.validateMoveFoward(0)).isFalse();
        assertThat(Racing.validateMoveFoward(1)).isFalse();
        assertThat(Racing.validateMoveFoward(3)).isFalse();
        assertThat(Racing.validateMoveFoward(4)).isTrue();
        assertThat(Racing.validateMoveFoward(9)).isTrue();
        assertThat(Racing.validateMoveFoward(10)).isFalse();
    }

    @Test
    @DisplayName("두 대의 차량을 앞으로 이동 시킨다")
    void 두_대의_차량을_앞으로_이동_시킨다() {

        Car aCar = new Car("aCar");
        Car bCar = new Car("bCar");

        carList.add(aCar);
        carList.add(bCar);

        Racing racing = new Racing();

        Racing.moveForwardOrStay(carList);

        assertThat(carList.get(0).confirmNowPosition()).isEqualTo(1);
        assertThat(carList.get(1).confirmNowPosition()).isEqualTo(1);
    }









}