package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCarsTest {
    private Cars cars;
    private List<Integer> distances;

    @BeforeEach
    void setUp() {
        cars = new Cars(
                Arrays.asList(
                        new Car("sally"),
                        new Car("eric"),
                        new Car("jin")
                )
        );
        distances = Arrays.asList(2,4,5);
    }

    @Test
    void 차량_모두_한번에_이동() {
        List<Integer> originalPositions = new ArrayList<>();
        for(Car car: cars.getCars()) {
            originalPositions.add(car.getPosition());
        }
        cars.moveCars(distances);
        int index = 0;
        List<Integer> expectedPositions = Arrays.asList(0,4,5);
        for(Car car: cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(expectedPositions.get(index));
            index+=1;
        }
    }

}
