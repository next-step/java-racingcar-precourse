package utils;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.AttemptBelowZeroException;
import exceptions.CarCountLessThenTwoException;
import exceptions.CarNameLengthException;
import exceptions.DuplicatedCarNameException;
import exceptions.NoneIntegerArgumentException;
import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 0글자인 경우 예외 발생")
    void validateCarNames_car_name_length_0() {

        // given
        List<String> carNames = List.of("", "pobi", "crong");

        // when
        // then
        assertThrows(CarNameLengthException.class, () -> InputValidator.validateCarNames(carNames));

    }

    @Test
    @DisplayName("자동차 이름이 5글자 이상인 경우 예외 발생")
    void validateCarNames_car_name_length_6() {

        // given
        List<String> carNames = List.of("123456", "pobi", "crong");

        // when
        // then
        assertThrows(CarNameLengthException.class, () -> InputValidator.validateCarNames(carNames));

    }

    @Test
    @DisplayName("자동차 개수가 2개 미만(0개)인 경우 예외 발생")
    void validateCarNames_car_count_0() {

        // given
        List<String> carNames = List.of();

        // when
        // then
        assertThrows(CarCountLessThenTwoException.class, () -> InputValidator.validateCarNames(carNames));

    }

    @Test
    @DisplayName("자동차 개수가 2개 미만(1개)인 경우 예외 발생")
    void validateCarNames_car_count_1() {

        // given
        List<String> carNames = List.of("pobi");

        // when
        // then
        assertThrows(CarCountLessThenTwoException.class, () -> InputValidator.validateCarNames(carNames));

    }

    @Test
    @DisplayName("자동차 이름이 중복된 경우 예외 발생")
    void validateCarNames_duplicated_car_name() {

        // given
        List<String> carNames = List.of("pobi", "pobi", "crong");

        // when
        // then
        assertThrows(DuplicatedCarNameException.class, () -> InputValidator.validateCarNames(carNames));

    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닌 경우 예외 발생")
    void validateAttemptCount_not_integer() {

        // given
        String input = "a";

        // when
        // then
        assertThrows(NoneIntegerArgumentException.class, () -> InputValidator.validateAttemptCount(input));

    }

    @Test
    @DisplayName("시도 횟수가 0인 경우 예외 발생")
    void validateAttemptCount_not_positive() {

        // given
        String input = "0";

        // when
        // then
        assertThrows(AttemptBelowZeroException.class, () -> InputValidator.validateAttemptCount(input));

    }

}