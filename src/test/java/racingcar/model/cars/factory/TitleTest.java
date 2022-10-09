package racingcar.model.cars.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TitleTest {
    @Test
    void 호칭_자동차_이름_동일() {
        String carName = "자동차 명";
        assertThat(new Title(carName).get()).isEqualTo(carName);
    }
}
