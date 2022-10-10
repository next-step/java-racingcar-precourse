package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    @Test
    @DisplayName("자동차 이름을 확인한다.")
    void 자동차이름_확인() {
        // given
        List<Car> cars = Arrays.asList(
                Car.from("slow"), 
                Car.from("fast1"),
                Car.from("fast2"));

        // when
        cars.get(1).move();
        cars.get(2).move();
        Winners winners = new Winners(cars);
        
        // then
        assertThat(winners.getNames()).containsExactly("fast1", "fast2");
    }
}
