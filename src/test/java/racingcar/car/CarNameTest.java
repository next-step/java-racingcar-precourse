package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @Test
    @DisplayName("5자 초과가 입력되면 IllegalArgumentException 발생")
    void validateCarName() {
        String testCarName = "carNameTest";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CarName carName = new CarName(testCarName);
        }).withMessage("[ERROR] The car name is limited to 5 characters or less. but your input: " + testCarName);
    }

}
