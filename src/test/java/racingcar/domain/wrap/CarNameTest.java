package racingcar.domain.wrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_LENGTH_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022-04-22 오후 11:59
 */
@DisplayName("Domain:Wrap:CarName")
class CarNameTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("1~5자의 String으로 표현되는 자동차 이름 포장 객체 생성 Test")
    public void createCarNameTest(String given) {
        // When & Then
        assertThat(new CarName(given));
    }

    private static Stream createCarNameTest() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of("ab cd"),
                Arguments.of("abced")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("1~5자의 String으로 표현되는 자동차 이름 포장 객체 생성 실패 Test")
    public void createCarNameFailTest(String given) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(given))
                .withMessageContaining(INVALID_CAR_NAME_LENGTH_MESSAGE);
    }

    private static Stream createCarNameFailTest() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("ab cde")
        );
    }
}