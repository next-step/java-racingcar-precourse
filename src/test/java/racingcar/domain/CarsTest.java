package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 생성된_Cars_객체의_자동차_이름들은_입력된_CarNames_객체의_자동차_이름과_같아야_한다() {
        // given
        final String carNamesInput = "benz,audi,bmw";
        final CarNames carNames = CarNames.of(carNamesInput);

        // when
        final Cars cars = Cars.of(carNames);

        // then
        Assertions.assertThat(cars.getWinners().replaceAll(" ", "")).isEqualTo(carNamesInput);
    }

}
