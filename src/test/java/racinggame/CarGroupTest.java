package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.CarGroup;
import racinggame.model.CarNames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarGroupTest {
    @DisplayName("잘못된 파라미터 전달")
    @Test
    void checkCarGroupIllegalArgument() {
        CarNames carNames = new CarNames("aaaaa,bbbbbbbb,cccccc123234");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new CarGroup(carNames));
    }
}
