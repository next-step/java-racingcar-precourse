package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car("aaaa");
    }

    @DisplayName("자동차 이름 생성")
    @Test
    void carNameValidTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car carTest = new Car("aaaaaa");
        });
    }

    @DisplayName("자동차 상태 확인")
    @Test
    void carPositionTest() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void forwardCarTest() {
        car.forward();
        assertThat(car.getPosition()).isEqualTo(1);
    }



}
