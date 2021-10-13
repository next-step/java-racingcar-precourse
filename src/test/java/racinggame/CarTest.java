package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;
import racinggame.model.CarGroup;
import racinggame.model.CarNames;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    @DisplayName("잘못된 파라미터 전달")
    @Test
    void checkCarIllegalArgument() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car(""));
    }
}
