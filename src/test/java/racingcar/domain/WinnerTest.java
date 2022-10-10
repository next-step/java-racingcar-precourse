package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @DisplayName("우승자 자동차 이름을 조회한다")
    @Test
    void 우승한_자동차_이름을_조회한다() {
        // given
        Winner winner = new Winner(getWinners());

        // when
        String[] names = winner.getNames();

        // then
        assertThat(names.length).isEqualTo(2);
        assertThat(names[0]).isEqualTo("pobi");
        assertThat(names[1]).isEqualTo("aa");
    }

    private Cars getWinners() {
        Cars winners = new Cars(new ArrayList<>());
        winners.addCar(new Car("pobi"));
        winners.addCar(new Car("aa"));
        return winners;
    }
}