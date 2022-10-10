package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {

    @Test
    @DisplayName("자동차 이름으로 자동차를 생성한다.")
    void createCar_withName() {
        //given
        String carName = "나현자동차";

        //then
        assertDoesNotThrow(() -> Car.createCar(carName));
    }

    @Test
    @DisplayName("자동차 이름으로 자동차를 생성하면 거리는 0인 상태로 생성된다.")
    void createCar_withName_hasZeroPosition() {
        //given
        String carName = "나현자동차";

        //then
        Car car = Car.createCar(carName);

        //then
        assertThat(car.getPosition().getIntPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 전진상태라면 거리가 1만큼 증가한다.")
    void playRound_withMoveStatus() {
        //given
        Car car = Car.createCar("나현자동차");

        //when
        car.playRound(CarStatus.MOVE);

        //then
        assertThat(car.getPosition().getIntPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 정지상태라면 거리가 증가하지 않는다.")
    void playRound_withStopStatus() {
        //given
        Car car = Car.createCar("나현자동차");

        //when
        car.playRound(CarStatus.STOP);

        //then
        assertThat(car.getPosition().getIntPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("차의 이름을 반한다.")
    void test_getCarName() {
        //given
        String name = "car1";
        Car car = Car.createCar(name);

        //when
        String carName = car.getName().getCarName();

        //then
        assertThat(carName).isEqualTo(name);
    }
}
