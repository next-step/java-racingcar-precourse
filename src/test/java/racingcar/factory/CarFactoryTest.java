package racingcar.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    @Test
    @DisplayName("자동차_리스트_생성")
    void 자동차_생성() {
        String names = "KRAD, KRADJ, KRADK";
        assertThat(new CarFactory().getCars(names)).isInstanceOf(Cars.class);
    }
}
