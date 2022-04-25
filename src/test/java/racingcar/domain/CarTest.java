package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 전진하는 경우 주행 거리를 기록한다.")
    @Test
    public void run() {
        // given
        Car car = new Car("그랜져");
        Mileage origin = car.getMileage();
        int randomNumber = 4;
        // when
        car.run(randomNumber);
        Mileage mileage = car.getMileage();
        // then
        assertThat(origin.getMeter()).isLessThan(mileage.getMeter());
    }

    @DisplayName("자동차가 멈춘 경우 주행거리는 이전 주행 거리와 같다.")
    @Test
    public void stop() {
        // given
        Car car = new Car("그랜져");
        Mileage origin = car.getMileage();
        origin = origin.plus();
        int randomNumber = 3;
        // when
        car.run(randomNumber);
        Mileage mileage = car.getMileage();
        mileage = mileage.plus();
        // then
        assertThat(origin).isEqualTo(mileage);
    }

    @DisplayName("자동차의 주행 거리를 기록한다.")
    @Test
    public void record() {
        // given
        String name = "그랜져";
        Car car = new Car(name);
        Round round = new Round();

        int randomNumber = 4;
        Mileage mileage = Mileage.init().plus();
        CarName carName = new CarName(name);
        // when
        car.run(randomNumber);
        car.record(round);
        // then
        assertThat(mileage).isEqualTo(round.getMileage(carName));
    }
}
