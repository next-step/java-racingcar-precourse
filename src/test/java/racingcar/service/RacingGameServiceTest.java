package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.ErrorMessage;
import racingcar.domain.RacingTryCount;

@DisplayName("RacingGameServiceTest클래스")
public class RacingGameServiceTest {

    private RacingGameService racingGameService;

    @BeforeEach
    void setup() {
        racingGameService = new RacingGameService();
    }

    @Nested
    @DisplayName("validateTryCount()는")
    class Describe_Validate_TryCount {

        @Nested
        @DisplayName("0이상의 정수를 문자열로 받으면")
        class Context_Valid_Input {

            @ParameterizedTest
            @CsvSource(value = {"594:594", "411:411", "236:236", "6212:6212"}, delimiter = ':')
            @DisplayName("해당 값을 갖고 있는 RacingTryCount 일급 콜렉션을 반환한다.")
            void It_Returns_RacingTryCount(String input, Integer expected) {

                final RacingTryCount racingTryCount = racingGameService.validateTryCount(input);

                assertThat(racingTryCount.getCount()).isEqualTo(expected);

            }

        }

        @Nested
        @DisplayName("0이하의 정수를 문자열로 받으면")
        class Context_Invalid_Integer_Input {

            @ParameterizedTest
            @ValueSource(strings = {"0", "-1", "-254", "-1482"})
            @DisplayName("IllegalArgumentException(횟수는 1이상의 정수만 입력 가능합니다.)을 발생시킨다.")
            void it_Throws_IllegalArgumentException(String input) {

                final IllegalArgumentException illegalArgumentException =
                        assertThrows(IllegalArgumentException.class, () -> racingGameService.validateTryCount(input));

                final String errorMessage = illegalArgumentException.getMessage();

                assertThat(errorMessage).isEqualTo(ErrorMessage.TRY_COUNT_IS_NOT_INTEGER);

            }

        }

        @Nested
        @DisplayName("숫자가 아닌 문자열로 받으면")
        class Context_Not_Integer_Input {

            @ParameterizedTest
            @ValueSource(strings = {"five", "four", "seven", "eight"})
            @DisplayName("IllegalArgumentException(횟수는 1이상의 정수만 입력 가능합니다.)을 발생시킨다.")
            void it_Throws_IllegalArgumentException(String input) {

                final IllegalArgumentException illegalArgumentException =
                        assertThrows(IllegalArgumentException.class, () -> racingGameService.validateTryCount(input));

                final String errorMessage = illegalArgumentException.getMessage();

                assertThat(errorMessage).isEqualTo(ErrorMessage.TRY_COUNT_IS_NOT_INTEGER);

            }

        }

    }
}
