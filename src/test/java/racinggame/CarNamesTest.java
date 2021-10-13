package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.CarGroup;
import racinggame.model.CarNames;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarNamesTest {
    @DisplayName("CarNames의 유효성 체크")
    @Test
    void checkCarNamesValidate() {
        CarNames carNames = new CarNames("aaaaa,bbbbbbbb,cccccc123234");

        assertThat(carNames.isValidCarNames()).isFalse();
    }
}
