package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 우승자가_1명인_경우(String names) {
        Cars cars = new Cars(names);
        cars.getValues().get(0).getPosition().increase();
        Winners winners = new Winners(cars);

        assertThat(winners.getWinnersMessage()).isEqualTo("최종 우승자: pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 우승자가_1명이상인_경우(String names) {
        Cars cars = new Cars(names);
        cars.getValues().get(0).getPosition().increase();
        cars.getValues().get(1).getPosition().increase();
        Winners winners = new Winners(cars);

        assertThat(winners.getWinnersMessage()).isEqualTo("최종 우승자: pobi, woni");
    }

}
