package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Validation;

public class ValidationTest {
    @Nested
    @DisplayName("checkCarNameLen 메소드는")
    class Describe_checkCarNameLen {
        @DisplayName("자동차 이름이 다섯글자 이하이면")
        @Nested
        class Context_with_correct {
            @DisplayName("Ture를 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"prr", "rupi"})
            void car_name_length(String carName) {
                Validation validation = new Validation();
                assertThat(validation.checkCarNmaeLen(carName)).isTrue();
            }
        }

        @DisplayName("자동차 이름이 다섯글자 초과이면")
        @Nested
        class Context_with_incorrect {
            @DisplayName("False를 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"pororo", "rupiii"})
            void car_name_length(String carName) {
                Validation validation = new Validation();
                assertThat(validation.checkCarNmaeLen(carName)).isFalse();
            }
        }
    }

    @Nested
    @DisplayName("checkCarsNameNull 메소드는")
    class Describe_checkCarsNameNull {
        @DisplayName("자동차 이름 입력 값이 있으면")
        @Nested
        class Context_with_correct {
            @DisplayName("Ture를 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"prr", "rupi"})
            void car_name_not_null(String carName) {
                Validation validation = new Validation();
                assertThat(validation.checkCarsNameNull(carName)).isTrue();
            }
        }

        @DisplayName("자동차 이름 입력 값이 없으면")
        @Nested
        class Context_with_incorrect {
            @DisplayName("False를 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"''", "''"})
            void car_name_null(String carName) {
                Validation validation = new Validation();
                assertThat(validation.checkCarsNameNull(carName)).isFalse();
            }
        }
    }

    @Nested
    @DisplayName("checkChancesRange 메소드는")
    class Describe_checkChancesRange {
        @DisplayName("경주 시도 회수 입력값이 0초과라면")
        @Nested
        class Context_with_correct {
            @DisplayName("Ture를 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"1", "2", "3"})
            void chance_valid_range(Integer chance) {
                Validation validation = new Validation();
                assertThat(validation.checkChancesRange(chance)).isTrue();
            }
        }

        @DisplayName("경주 시도 회수 입력 값이 0이하라면")
        @Nested
        class Context_with_incorrect {
            @DisplayName("False를 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"0", "-1", "-4"})
            void chance_invalid_range(Integer chance) {
                Validation validation = new Validation();
                assertThat(validation.checkChancesRange(chance)).isFalse();
            }
        }
    }
}
