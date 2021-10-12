package racinggame.game.car;

import org.junit.jupiter.api.Test;
import racinggame.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerForwardMovementCountTest extends BaseTest<Car> {

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
            Car car = new Car("c" + i);
            setPrivateField(car, "forwardMovementCount", forwardMovementCount);
            cars.add(car);
        }
        return cars;
    }

}