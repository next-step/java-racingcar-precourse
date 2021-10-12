package racinggame.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.game.model.car.CarName;
import racinggame.game.model.car.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("cars 이름 비교 테스트")
    @Test
    void testGetCarList() {
        int size = 3;
        List<CarName> carNames = createCarNames(size);
        Cars cars = new Cars(carNames);
        assertThat(cars.getCarList().size() == size).isTrue();

        for (int i = 0; i < size; i++) {
            assertThat(carNames.get(i).getCarName().equals(cars.getCarList().get(i).getCarName().getCarName())).isTrue();
        }
    }

    private List<CarName> createCarNames(int size) {
        List<CarName> carNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carNames.add(new CarName("c" + i));
        }
        return carNames;
    }
}