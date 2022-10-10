package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Name("테스트카~"));
    }

    @Test
    void 자동차_이름_생성() {
        assertThat(car.getName()).isEqualTo("테스트카~");
    }

    @Test
    void 자동차_전진_성공() {
        int randomNumber = 4;
        car.move(randomNumber);

        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    void 자동차_전진_실패() {
        int randomNumber = 3;
        car.move(randomNumber);

        assertThat(car.getMove()).isEqualTo(0);
    }
}