package racingcar.model.collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarGroupsTest {

    @Test
    void 자동차_다건_생성_확인() {
        String carNames = "자동차1,자동차2,자동차3";
        CarGroups cars = new CarGroups(carNames);
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 자동차_다건_생성_확인_최소() {
        String carNames = "자동차1";
        CarGroups cars = new CarGroups(carNames);
        assertThat(cars.getCars()).hasSize(1);
    }

    @Test
    void 자동차_이동_테스트() {
        String carNames = "자동차1";
        CarGroups carGroups = new CarGroups(carNames);

        for (Car car : carGroups.getCars()) {
            assertThat(car.getDrivingDistance().getDistance()).isZero();
        }
        for (int i = 0; i < 20; i++) {
            carGroups.moveAll();
        }
        for (Car car : carGroups.getCars()) {
            assertThat(car.getDrivingDistance().getDistance()).isNotZero();
        }
    }

}