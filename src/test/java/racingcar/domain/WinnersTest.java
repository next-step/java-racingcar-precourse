package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @DisplayName("우승자 이름 반환 확인")
    @Test
    void winnerNames() {
        List<Car> cars = Arrays.asList(
            new Car("Car1"),
            new Car("Win1")
        );
        Winners winners = new Winners(cars);

        List<String> names = winners.getNames();

        assertThat(names.size()).isEqualTo(2);
        assertThat(names.toString()).contains("Car1", "Win1");
    }
}