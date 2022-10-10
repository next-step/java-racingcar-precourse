package racingcar.domain.car.carname;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.carname.validation.CarNameValidator;
import racingcar.domain.car.carname.validation.DefaultCarNameValidator;

public class CarNameTest {

    CarNameValidator validator = new DefaultCarNameValidator();

    @Test
    void success() {
        assertThatNoException().isThrownBy(() -> new CarName("pobi", validator));
    }

    @Test
    @DisplayName("차이름의 길이가 5자 넘으면 EX 발생")
    void five_length() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName("yoonmin", validator))
                .withMessageStartingWith("[ERROR]");
    }
}
