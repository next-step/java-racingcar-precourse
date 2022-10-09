package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("abcd");
    }

    @Test
    void 이름_5글자초과할경우_에러() {
        assertThatThrownBy(() -> new Car("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 이름_0글자일경우_에러() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 이름_유효할경우_객체생성() {
        assertThat(car).isNotNull();
    }

    @Test
    void 이동할경우_랜덤값에따라_이동하거나정차() {
        car.move();
        String status = car.getDistance();

        assertThat(status).containsAnyOf("-", "");
    }
}
