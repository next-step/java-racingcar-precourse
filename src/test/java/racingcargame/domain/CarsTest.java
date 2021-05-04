package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("우승자를 추려내어 우승자 이름을 구한다.")
    void getWinnersTest() {
        Cars cars = Cars.makeCars("a,b,c");
        cars.get(0).move(4);
        cars.get(1).move(3);
        cars.get(2).move(4);

        Winners winners = cars.getWinners();
        assertThat(winners.getWinnersName()).isEqualTo("a, c");
    }
}