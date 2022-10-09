package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void next(int moveNum) {
        assertEquals(car.play(moveNum), CarStatus.NEXT);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(int moveNum) {
        assertEquals(car.play(moveNum), CarStatus.STOP);
    }

}
