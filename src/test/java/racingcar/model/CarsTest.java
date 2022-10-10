package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = { "아반떼,소나타" })
    void 자동차_쉼표로_파싱(String inputNames) {
        String[] carsName = inputNames.split(",");
        Cars cars = new Cars(inputNames);

        for (int i = 0; i < carsName.length; i++) {
            assertThat(cars.getCars().get(i).getName()).isEqualTo(carsName[i]);
        }
    }
}
