package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarTest() {
        String testName = "test";
        Car car = Car.create(testName);
        assertThat(car.getName()).isEqualTo(testName);
    }

}
