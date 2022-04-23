package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    private static final int TEST_CAR_LIST_LENGTH = 4;

    @Test
    void 정상적인_자동차_리스트로_생성() {
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < TEST_CAR_LIST_LENGTH; i++) {
            carList.add(new Car(String.valueOf(i)));
        }

        Cars cars = new Cars(carList);
        assertThat(cars.size()).isEqualTo(TEST_CAR_LIST_LENGTH);
    }

    @Test
    void 빈_리스트로_생성() {
        List<Car> emptyList = new ArrayList<>();

        assertThatThrownBy(() -> new Cars(emptyList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null_으로_생성() {
        assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}