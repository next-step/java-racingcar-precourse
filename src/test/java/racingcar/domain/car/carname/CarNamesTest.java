package racingcar.domain.car.carname;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.carname.validation.CarNameValidator;
import racingcar.domain.car.carname.validation.CarNamesValidator;
import racingcar.domain.car.carname.validation.DefaultCarNameValidator;
import racingcar.domain.car.carname.validation.DefaultCarNamesValidator;

class CarNamesTest {

    CarNamesValidator carNamesValidator = new DefaultCarNamesValidator();
    CarNameValidator carNameValidator = new DefaultCarNameValidator();

    @Test
    void success() {
        assertThatNoException().isThrownBy(() -> new CarNames("pobi,woni,", carNamesValidator));
    }

    @Test
    @DisplayName("차이름의 길이가 5자 넘으면 EX 발생")
    void five_length() {
        CarNames carNames = new CarNames("pobi,woni,yoonmin", carNamesValidator);
        assertThatIllegalArgumentException().isThrownBy(() -> carNames.createCarNames(carNameValidator))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    @DisplayName("첫단어가 쉼표(,)면 EX 발생")
    void first_comma() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarNames(",pobi,woni", carNamesValidator))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    @DisplayName("차이름이 공백이면 EX 발생")
    void empty() {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarNames("", carNamesValidator))
                .withMessageStartingWith("[ERROR]");
    }
}