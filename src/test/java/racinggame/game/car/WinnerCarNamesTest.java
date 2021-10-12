package racinggame.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarNamesTest extends BaseTest<Car> {

    @DisplayName("우승자 이름 비교 테스트")
    @Test
    void test() {
        int winnerCount = 2;
        List<String> winnerCarNameList = createWinnerCarNames(winnerCount);

        int winnerForwardMovementCount = 10;

        List<Car> cars = new ArrayList<>();
        cars.addAll(createCars(winnerCarNameList, winnerForwardMovementCount));
        cars.addAll(createCars(2, 0));

        WinnerCarNames winnerCarNames = new WinnerCarNames(cars, winnerForwardMovementCount);
        for (int i = 0; i < winnerCount; i++) {
            assertThat(winnerCarNames.getWinnerCarNames().contains(winnerCarNameList.get(i))).isTrue();
        }
    }

    private List<Car> createCars(List<String> carNames, int forwardMovementCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            setPrivateField(car, "forwardMovementCount", forwardMovementCount);
            cars.add(car);
        }
        return cars;
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

    private List<String> createWinnerCarNames(int size) {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carNames.add("w" + i);
        }
        return carNames;
    }
}