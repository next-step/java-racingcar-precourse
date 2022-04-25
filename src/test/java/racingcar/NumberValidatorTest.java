package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.utils.NumberValidator;

class NumberValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1","2","3","4","5","6"})
    public void 레이스_횟수가_양수이면_성공한다(String input) {
        // given & when
        boolean result = NumberValidator.isValidCountInput(input);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"a","b","c","$","일"})
    public void 레이스_횟수가_숫자가_아니면_실패한다(String input) {
        // given & when
        boolean result = NumberValidator.isValidCountInput(input);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1.1","2.2","3.14","4.5","5.0"})
    public void 레이스_횟수가_소수이면_실패한다(String input) {
        // given & when
        boolean result = NumberValidator.isValidCountInput(input);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"0","-1","-2","-3"})
    public void 레이스_횟수가_0또는_음수이면_실패한다(String input) {
        // given & when
        boolean result = NumberValidator.isValidCountInput(input);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void 레이스_횟수가_빈값이면_실패한다() {
        // given & when
        boolean result = NumberValidator.isValidCountInput("");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void 레이스_횟수가_null값이면_실패한다() {
        // given & when
        boolean result = NumberValidator.isValidCountInput(null);

        // then
        assertThat(result).isFalse();
    }
}