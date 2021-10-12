package racinggame.game.car;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void testGetCarList() {
        int size = 3;
        List<String> carNames = createCarNames(size);
        Cars cars = new Cars(carNames);
        assertThat(cars.getCarList().size() == size).isTrue();

        for (int i = 0; i < size; i++) {
            assertThat(carNames.get(i).equals(cars.getCarList().get(i).getName())).isTrue();
        }
    }



    private List<String> createCarNames(int size) {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carNames.add("car-0" + i);
        }
        return carNames;
    }
}