package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNamesTest {

    @Test
    void 차_이름_리스트_생성() {
        String input = "A,B,C";

        CarNames carNames = CarNames.create(input);

        assertThat(carNames.getList().stream().map(CarName::getName)).contains("A", "B", "C");
    }

}