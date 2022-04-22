package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingTest {
    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("hello"), new Car("java"), new Car("world"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "A", "가"})
    void 레이싱_자동차_이동횟수는_숫자(String input) {
        assertThatThrownBy(() -> new Racing(input, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수만큼_자동차들을_이동() {
        Racing racing = new Racing("5", cars);
        racing.race();
        for (Car car : racing.getCars()) {
            assertThat(car.getDistance()).isLessThanOrEqualTo(racing.getMoveCount()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 자동차_최대_이동거리는_이동횟수보다_같거나_낮다() {
        Racing racing = new Racing("5", cars);
        racing.race();
        assertThat(racing.getMaxCarDistance()).isLessThanOrEqualTo(racing.getMoveCount());
    }

    @Test
    void 이동거리가_제일_큰_자동차_리스트_구하기() {
        Racing racing = new Racing("5", cars);
        racing.race();
        List<Car> winners = racing.getWinner();
        for (Car car : winners) {
            assertThat(car.getDistance()).isEqualTo(racing.getMaxCarDistance());
        }
    }
}