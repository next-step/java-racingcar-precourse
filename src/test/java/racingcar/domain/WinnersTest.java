package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    private Winners winners;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("car1", 3));
        carList.add(new Car("car2", 5));
        carList.add(new Car("car3", 5));
        winners = new Winners(carList);
    }

    @DisplayName("우승자를 출력하는 객체를 생성한다.")
    @Test
    void construct() {
        assertThat(winners).isNotNull();
    }

    @DisplayName("우승자를 찾아 출력한다.")
    @Test
    void get() {
        List<Winner> winnerList =  winners.get();
        assertThat(winnerList).hasSize(2);
        assertThat(winnerList.get(0)).isEqualTo(new Winner("car2"));
        assertThat(winnerList.get(1)).isEqualTo(new Winner("car3"));
    }
}
