package racingcar.domain.cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.error.ErrorMessage;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.engine.Engine;
import racingcar.vo.racenumber.RaceNumber;

class CarsTest {
    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final int MOVABLE_DISTANCE = 1;
    private static final int INIT_DISTANCE = 0;
    Cars cars;

    @BeforeEach
    public void before() {
        cars = new Cars();
        String[] names = {"car1", "car2", "car3"};

        for (String name : names) {
            Car newCar = new Car(name, INIT_DISTANCE, new Engine(MOVABLE_MIN_NUMBER, MOVABLE_DISTANCE));
            cars.participate(newCar);
        }
    }

    @DisplayName("자동차 추가 테스트")
    @Test
    public void 자동차_추가() {
        String newCarName = "car4";
        Car newCar = new Car(newCarName, INIT_DISTANCE, new Engine(MOVABLE_MIN_NUMBER, MOVABLE_DISTANCE));
        cars.participate(newCar);
        List<Car> participatedCars = cars.getParticipatedCars();
        assertThat(participatedCars.get(participatedCars.size() - 1).getName())
                .isEqualTo(Name.from(newCarName));
    }

    @DisplayName("중복된 자동차 이름 예외")
    @Test
    public void 중복된_자동차_이름_예외() {
        String duplicatedCarName = "car1";
        Car duplicatedCar = new Car(duplicatedCarName, INIT_DISTANCE,
                new Engine(MOVABLE_MIN_NUMBER, MOVABLE_DISTANCE));
        assertThatThrownBy(() -> cars.participate(duplicatedCar)).isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.MSG_DUPLICATE_NAME.getMessage());
    }

    @DisplayName("우승 자동차 반환")
    @Test
    public void 우승_자동차_반환() {
        Car[] winningCars = {cars.getParticipatedCars().get(0), cars.getParticipatedCars().get(2)};
        for (Car winningCar : winningCars) {
            winningCar.move(RaceNumber.from(5));
        }
        assertThat(cars.getWinningCars()).contains(winningCars);
    }
}