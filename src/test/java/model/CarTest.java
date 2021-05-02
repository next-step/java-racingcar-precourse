package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final String CAR_NAME = "edge";

    @DisplayName("전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 100})
    void TEST_go(int num) {
        Car car = new Car(CAR_NAME);
        for (int i = 0; i < num; i++) {
            car.go();
        }
        assertThat(car.getScore()).isEqualTo(num);
        System.out.println(car.toString());
    }
}
