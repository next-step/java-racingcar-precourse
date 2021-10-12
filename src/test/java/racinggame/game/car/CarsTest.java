package racinggame.game.car;

import org.junit.jupiter.api.Test;
import racinggame.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest extends BaseTest<Cars> {

    @Test
    void testGetCarList() {
        int size = 3;
        Cars cars = new Cars(getDefaultCarNames(size));
        assertThat(cars.getCarList().size() == size).isTrue();
    }


    private List<String> getDefaultCarNames(int size) {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carNames.add("car-0" + i);
        }
        return carNames;
    }
}