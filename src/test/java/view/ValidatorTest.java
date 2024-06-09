package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        this.validator = new Validator();
    }

    @Test
    void 자동차_이름_검증_성공() {
        // given
        String input = "car1,car2,car3";
        // when, then
        validator.validateCarName(input);
    }

    @Test
    void 자동차_이름_검증_실패() {
        //given
        String invalidName = "invalidName,car1,car2";
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateCarName(invalidName);
        });
    }

    @Test
    void 시도_횟수_검증_성공() {
        // given
        String input = "5";
        // when, then
        validator.validateInputRacingCount(input);
    }

    @Test
    void 시도_횟수_검증_실패() {
        //given
        String input = "invalidCount";
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInputRacingCount(input);
        });
    }


}