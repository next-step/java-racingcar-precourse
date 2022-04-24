package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * author : citizen103
 */
public class CarTest {

    @Test
    void 자동차_이동_테스트() {
        // Given
        String carName = "test";
        Car car = new Car(carName);

        // When
        car.move(4);

        // Then
        assertThat(car.getCarName()).isEqualTo(carName);
        assertThat(car.isMovementSame(1)).isTrue();
    }

}
