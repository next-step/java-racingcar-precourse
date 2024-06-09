package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("승자 룰 테스트")
class WinnerRuleTest {
    @Test
    void 위치가_가장_높은_자동차_목록을_반환한다() {
        Car car1 = createCar("pobi", 9);
        Car car2 = createCar("woni", 0);
        Car car3 = createCar("jun", 9);
        Car car4 = createCar("jason", 0);
        Cars cars = new Cars(car1, car2, car3, car4);
        WinnerRule winnerRule = WinnerRules.HIGHEST_POSITION;

        Cars winner = winnerRule.winner(cars);

        assertThat(winner).isEqualTo(new Cars(car1, car3));
    }

    private Car createCar(final String name, final int position) {
        Name carName = new Name(name);
        Position carPosition = new Position(position);
        return new Car(carName, carPosition);
    }
}
