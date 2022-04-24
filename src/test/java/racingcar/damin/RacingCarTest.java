package racingcar.damin;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void RacingCar_NameIsEmpty_ExceptionThrown() {
        String name = "";

        assertThatThrownBy(() -> new RacingCar(CarName.of(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void RacingCar_NameLengthIsMoreThan5_ExceptionThrown() {
        String name = "Jeremy";

        assertThatThrownBy(() -> new RacingCar(CarName.of(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void RacingCar_GivenName_NotExceptionThrown() {
        String name = "Ewan";
        RacingCar racingCar = new RacingCar(CarName.of(name));

        assertThat(racingCar.getName()).isEqualTo(name);
    }
}
