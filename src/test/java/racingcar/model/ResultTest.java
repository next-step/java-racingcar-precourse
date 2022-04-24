package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.PlayResult;
import racingcar.model.Repeat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultTest {

    @Test
    void move테스트() {
        Cars cars = new Cars("a,b,c");
        cars.move();
        for (Integer position : cars.getPositions()) {
            assertThat(position).isBetween(0, 1);
        }
    }

    @Test
    void 우승자찾기() {
        Cars cars = new Cars("c,b,a");
        Repeat repeatTime = new Repeat("2");
        while (!repeatTime.isEnd()) {
            cars.move();
            repeatTime.reduce();
        }
        PlayResult result = cars.findWinner();
        assertThat(result.resultSetting()).isLessThanOrEqualTo("c,b,a");
    }
}
