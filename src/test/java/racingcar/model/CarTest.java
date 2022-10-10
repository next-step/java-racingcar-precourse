package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private Car car;

    @BeforeEach
    void 자동차() {
        car = new Car("롤스로이스");
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 3 })
    void 입력_값이_3이하면_위치_멈춤(int number) {
        int beforeDistance = car.getDistance();
        car.moveForward(number);

        assertEquals(car.getDistance(), beforeDistance);
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 9 })
    void 입력_값이_3이하면_위치_전진(int number) {
        int beforeDistance = car.getDistance();
        car.moveForward(number);

        assertThat(beforeDistance < car.getDistance()).isTrue();
    }
}
