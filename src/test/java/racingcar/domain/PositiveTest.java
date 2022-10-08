package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositiveTest {

    @Test
    @DisplayName("기본 생성자 생성")
    void 기본_생성자_생성() {
        Positive positive = new Positive();
        assertThat(positive.intValue()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 정상_범위_숫자_생성자_생성(final int input) {
        assertDoesNotThrow(() -> new Positive(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void 비정상_범위_숫자_생성자_생성(final int input) {
        assertThrows(IllegalArgumentException.class, () -> new Positive(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2"})
    void 정상_범위_문자열_생성자_생성(final String  input) {
        assertDoesNotThrow(() -> new Positive(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void 비정상_범위_문자열_생성자_생성1(final String  input) {
        assertThrows(IllegalArgumentException.class, () -> new Positive(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "ㅁ", " ", ""})
    void 비정상_범위_문자열_생성자_생성2(final String  input) {
        assertThrows(IllegalArgumentException.class, () -> new Positive(input));
    }
}
