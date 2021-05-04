package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    @DisplayName("우승자 이름을 문자열로 반환한다.")
    void toStringTest() {
        Car car1 = Car.of(CarName.of("cn1"));
        Car car2 = Car.of(CarName.of("cn2"));

        Winners winners = new Winners();
        winners.add(car1);
        winners.add(car2);

        assertThat(winners.getWinnersName()).isEqualTo("cn1, cn2");
    }
}