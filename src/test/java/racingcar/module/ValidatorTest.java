package racingcar.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("레이싱카의 이름들을 검증한다.")
    @ValueSource(strings = {
            "asyu,test,test2",
            "asyu,test,test2,test3,test4,test5,test6",
            "a,b,c,d,e,f,g"
    })
    @ParameterizedTest
    void validate_racing_car_names(String input) {
        // Given

        // When
        boolean validated = Validator.validateRacingCarNames(input);

        // Then
        assertThat(validated).isTrue();
    }

    @DisplayName("잘못된 레이싱카의 이름들을 검증한다.")
    @CsvSource(value = {
            ":input is not empty or null",
            "                      :input is not empty or null",
            "asyu88:invalid input name",
            "abcdefghi:invalid input name",
            "asyu1,asyu2,asyu2:invalid input name",
            ",,,:invalid input name",
            "   ,   ,   ,:invalid input name",
    }, delimiter = ':')
    @ParameterizedTest
    void validate_invalid_racing_car_names(String input, String contains) {
        // Given

        // When && Then
        assertThatThrownBy(() -> {
            Validator.validateRacingCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(contains);
    }

    @DisplayName("올바른 레이싱 횟수를 검증한다.")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "9999", "1000", "1002"})
    @ParameterizedTest
    void validate_racing_count(String input) {
        // Given

        // When
        boolean validated = Validator.validateRacingCount(input);

        // Then
        assertThat(validated).isTrue();
    }

    @DisplayName("레이싱 횟수 음수를 검증한다.")
    @ValueSource(strings = {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-9999", "-1000", "-1002"})
    @ParameterizedTest
    void validate_negative(String input) {
        // When && Then
        assertThatThrownBy(() -> {
            Validator.validateRacingCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 레이싱 횟수를 검증한다.")
    @ValueSource(strings = {"       ", "invalid", "한글"})
    @ParameterizedTest
    void validate_not_numeric(String input) {
        // When && Then
        assertThatThrownBy(() -> {
            Validator.validateRacingCount(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}