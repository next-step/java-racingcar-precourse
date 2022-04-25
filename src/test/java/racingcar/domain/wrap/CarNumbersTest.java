package racingcar.domain.wrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.ErrorMessage.INVALID_NUMBER_BOUNDARY_MESSAGE;
import static racingcar.domain.wrap.CarNumbers.END_NUMBER;
import static racingcar.domain.wrap.CarNumbers.START_NUMBER;

/**
 * @author : choi-ys
 * @date : 2022-04-22 오후 11:58
 */
@DisplayName("Domain:Wrap:CarNumbers")
class CarNumbersTest {

    @Test
    @DisplayName("1~9 사이의 int 원시타입으로 표현되는 난수 포장 객체 생성 Test")
    public void createCarNumbersTest() {
        // When & Then
        assertThat(new CarNumbers()).isNotNull();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("1~9 사이의 난수 추가 Test")
    public void addRandomNumberToCarNumbersTest(int given) {
        // Given
        CarNumbers carNumbers = new CarNumbers();

        // When
        carNumbers.addNumber(given);

        // Then
        assertThat(carNumbers.getRandomNumberByRound(1)).isEqualTo(given);
        assertThat(carNumbers.getRandomNumberByRound(1)).isBetween(START_NUMBER, END_NUMBER);
    }

    private static Stream addRandomNumberToCarNumbersTest() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(9)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("1~9 사이의 난수 추가 실패 Test")
    public void addRandomNumberToCarNumbersFailTest(int given) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarNumbers().addNumber(given))
                .withMessageContaining(INVALID_NUMBER_BOUNDARY_MESSAGE);
    }

    private static Stream addRandomNumberToCarNumbersFailTest() {
        return Stream.of(
                Arguments.of(Integer.MIN_VALUE),
                Arguments.of(0),
                Arguments.of(10),
                Arguments.of(Integer.MAX_VALUE)
        );
    }
}