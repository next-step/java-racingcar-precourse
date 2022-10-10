package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinnersTest {

    @DisplayName("게임 실행시 단 한명의 일등=jplee이 존재한다.")
    @Test
    void onlyOneWinner() {
        // given
        Cars cars = Cars.release("mrlee,jplee,pobi");
        Coordinates coordinates = Coordinates.generate(2, 5, 3);
        cars.move(coordinates);

        // when
        Ranking ranking = new Ranking(cars);
        Winners winners =  new Winners(ranking);

        // then
        System.out.println(winners.getWinRacers());
        assertThat(winners.getWinRacers()).isEqualTo("jplee");
    }

    @DisplayName("게임 실행시 단 한명 이상의 일등=mrlee.pobi이 존재한다.")
    @Test
    void twoWinners() {
        // given
        Cars cars = Cars.release("mrlee,jplee,pobi");
        Coordinates coordinates = Coordinates.generate(8, 2, 6);
        cars.move(coordinates);

        // when
        Ranking ranking = new Ranking(cars);
        Winners winners =  new Winners(ranking);

        // then
        System.out.println(winners.getWinRacers());
        assertThat(winners.getWinRacers()).isEqualTo("mrlee,pobi");
    }
}