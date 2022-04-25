package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 3:14
 */
@DisplayName("Validator:TotalRoundValidator")
class TotalRoundValidatorTest {

    @Test
    @DisplayName("경주를 진행할 라운드 수 유효성 검증 Test")
    public void roundNumberValidationTest() {
        // Given
        String totalRound = "5";

        // When
        boolean isValidRoundNumber = TotalRoundValidator.isValidRoundNumber(totalRound);

        // Then
        assertThat(isValidRoundNumber).isTrue();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("유효하지 못한 라운드 수 유효성 검증 Test")
    public void invalidRoundNumberTest(String invalidRoundNumber) {
        // When
        boolean isValidRoundNumber = TotalRoundValidator.isValidRoundNumber(invalidRoundNumber);

        // Then
        assertThat(isValidRoundNumber).isFalse();
    }

    private static Stream invalidRoundNumberTest() {
        return Stream.of(
                Arguments.of("가"),
                Arguments.of("0"),
                Arguments.of("")
        );
    }
}