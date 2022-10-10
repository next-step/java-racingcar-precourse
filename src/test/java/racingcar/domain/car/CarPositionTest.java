package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarPositionTest {

    @Test
    @DisplayName("자동차의 움직인 거리를 생성할 때는 거리 0부터 시작한다.")
    void createCarPosition() {
        //when
        CarPosition carPosition = CarPosition.createNewCarPosition();

        //then
        assertThat(carPosition.getIntPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 움직인 거리가 n만큼 증가한다.")
    void moveNDistance() {
        //when
        CarPosition carPosition = CarPosition.createNewCarPosition();
        int moveDistance = 1;

        //when
        carPosition.move(moveDistance);

        //then
        assertThat(carPosition.getIntPosition()).isEqualTo(moveDistance);
    }


    @Test
    @DisplayName("자동차의 움직일 거리가 0보다 작으면 IllegalStateException을 반환한다.")
    void inValidMoveDistance() {
        //given
        CarPosition carPosition = CarPosition.createNewCarPosition();
        int moveDistance = -101;

        //when then
        assertThatThrownBy(() -> carPosition.move(moveDistance))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("경주게임에서는 후진할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 현재 움직인 거리를 반환한다.")
    void test_getPosition() {
        //given
        CarPosition carPosition = CarPosition.createNewCarPosition();
        int moveDistance = 5;

        //when
        carPosition.move(moveDistance);

        //then
        assertThat(carPosition.getIntPosition()).isEqualTo(moveDistance);
    }
}
