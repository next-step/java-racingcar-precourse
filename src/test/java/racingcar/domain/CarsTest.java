package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.application.CarsDTO;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux")
    void 자동차_개수_확인(final String names) {
        String[] carNames = new CarsDTO(names).toCarNames();

        assertThat(new Cars(carNames).getCars().size()).isEqualTo(carNames.length);
    }

    @Test
    void 우승자_생성_확인() {
        String[] carNames = new CarsDTO("pobi,crong,honux").toCarNames();
        Cars cars = new Cars(carNames);

        cars.playRound();
        cars.findWinners();

        assertThat(cars.getWinners().size()).isNotEqualTo(0);
    }

}