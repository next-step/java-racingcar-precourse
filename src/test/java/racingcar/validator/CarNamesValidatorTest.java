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
 * @date : 2022-04-25 오전 2:36
 */
@DisplayName("Validator:CarNamesValidator")
class CarNamesValidatorTest {

    @Test
    @DisplayName("자동차 이름 유효성 검증 부 Test")
    public void carNamesValidatorTest() {
        // Given
        String namesByComma = "마카롱택시,카카오택시,우티,타다";

        // When
        boolean isValidNames = CarNamesValidator.isValidCarNames(namesByComma);

        // Then
        assertThat(isValidNames).isTrue();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("유효하지 못한 자동차 이름 검증 Test")
    public void invalidCarNamesValidatorTest(String namesByComma) {
        // When
        boolean isValidNames = CarNamesValidator.isValidCarNames(namesByComma);

        // Then
        assertThat(isValidNames).isFalse();
    }

    private static Stream invalidCarNamesValidatorTest() {
        return Stream.of(
                Arguments.of("마카롱택시,"),
                Arguments.of("마카롱택시|카카오택시"),
                Arguments.of(""),
                Arguments.of("람보르기니 우라칸,아프릴리아 밀레")
        );
    }
}