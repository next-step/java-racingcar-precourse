package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차 이동 값이 4 이상이면 전진하고 3 이하면 멈춤")
    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1", "9,1"})
    void carMove(int distance, int expectedPosition) {
        Car car = new Car("abcde");

        car.move(new DistanceToMove(distance));

        int position = car.getPosition();
        assertThat(position).isEqualTo(expectedPosition);
    }
}
