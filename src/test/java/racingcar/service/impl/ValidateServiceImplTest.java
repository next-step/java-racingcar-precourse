package racingcar.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.service.ValidateService;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateServiceImplTest {

    private Cars cars;
    private ValidateService validateService;

    @BeforeEach
    void setUp() {
        validateService = new ValidateServiceImpl();
        cars = new Cars("car,race,test");
    }

    @Test
    void validateCarNameEmpty() {
        assertThatThrownBy(
                () -> validateService.validateCarNameEmpty(" ".trim())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNameLengthOver() {
        assertThatThrownBy(
                () -> validateService.validateCarNameLengthOver("lengthOver")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNameDuplicate() {
        assertThatThrownBy(
                () -> validateService.validateCarNameDuplicate(cars, "test")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputNumber() {
        assertThatThrownBy(
                () -> validateService.validateInputNumber("a")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}