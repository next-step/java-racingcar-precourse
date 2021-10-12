package racinggame.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void 자동차_이름_쉼표로_구분하여_반환() {
        String[] carNames = Validation.DivideCarNames("pobi");
        assertThat(carNames.length).isEqualTo(1);
        carNames = Validation.DivideCarNames("pobi,crong,honux");
        assertThat(carNames.length).isEqualTo(3);
    }

    @Test
    void 자동차_이름_길이_검증() {
        Boolean validated = Validation.validateCarNameLength("pollffsd");
        assertThat(validated).isEqualTo(false);
        validated = Validation.validateCarNameLength("polli");
        assertThat(validated).isEqualTo(true);
    }
}