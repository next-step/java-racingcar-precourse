package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "yang,SVC"})
    void 자동차들을_생성한다(String names) {
        Cars cars = new Cars(names);
        List<Car> carValue = cars.getValues();
        String[] namesArray = names.split(",");

        assertThat(carValue.size())
                .isEqualTo(namesArray.length);

        for (int i = 0; i < carValue.size(); i++) {
            assertThat(carValue.get(i)).isEqualTo(new Car(namesArray[i]));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "yang,SVC"})
    void 자동차들을_움직일_수_있다(String names) {
        Cars cars = new Cars(names);
        Position movedPosition = new Position();
        movedPosition.increase();

        cars.allCarsMove(() -> true);

        for (Car car : cars.getValues()) {
            assertThat(car.getPosition()).isEqualTo(movedPosition);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "yang,SVC"})
    void 자동차는_이동하지_않을_수_있다(String names) {
        Cars cars = new Cars(names);
        Position notMovedPosition = new Position();

        cars.allCarsMove(() -> false);

        for (Car car : cars.getValues()) {
            assertThat(car.getPosition()).isEqualTo(notMovedPosition);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차_중_가장_큰_위치값(String names) {
        int maxPosition = 5;
        Cars cars = new Cars(names);
        for (int i = 0; i < maxPosition; i++) {
            cars.getValues().get(0).getPosition().increase();
        }

        assertThat(cars.getLargestPositionAmongCars()).isEqualTo(maxPosition);

    }

}
