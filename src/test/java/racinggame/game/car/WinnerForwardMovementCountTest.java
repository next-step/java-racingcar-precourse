package racinggame.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.BaseTest;
import racinggame.game.model.car.Car;
import racinggame.game.model.car.CarName;
import racinggame.game.model.car.WinnerForwardMovementCount;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerForwardMovementCountTest extends BaseTest<Car> {

    @DisplayName("우승자 전진 횟수 비교 테스트")
    @Test
    void test() {
        int size = 3;
        int forwardMovementCount = 10;
        List<Car> cars = createCars(size, forwardMovementCount);
        WinnerForwardMovementCount winnerForwardMovementCount = new WinnerForwardMovementCount(cars);
        assertThat(forwardMovementCount == winnerForwardMovementCount.getWinnerForwardMovementCount()).isTrue();
    }

    private List<Car> createCars(int size, int forwardMovementCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Car car = new Car((new CarName("c" + i)));
            setPrivateField(car, "forwardMovementCount", forwardMovementCount);
            cars.add(car);
        }
        return cars;
    }

}