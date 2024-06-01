import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingInputHandlerTest {
    @DisplayName("splitCarNames test")
    @ParameterizedTest(name = "인자가 {0}일 때, {3}")
    @CsvSource({
            "'aaa, bbb,  ccc', false, 'aaa,bbb,ccc', '예외 발생하지 않고 올바르게 변환'",
            "' aaaaa,bbb,  ccc, d', false, 'aaaaa,bbb,ccc,d', '예외 발생하지 않고 올바르게 변환'",
            "'aaa, bbb,', false, 'aaa,bbb,', '예외 발생하지 않고 올바르게 변환'",
            "'aaa, bbb, ', true, 'aaa,bbb,', '예외 발생'",
            "'aaa, bbb, cccccc', true, 'aaa,bbb,cccccc', '예외 발생'"
    })
    public void splitCarNamesTest(String carNames, boolean error, String expected, String testName) {
        if (error) {
            Assertions.assertThatThrownBy(() -> {
                        RacingInputHandler.splitCarNames(carNames);
                    })
                    .isInstanceOf(IllegalArgumentException.class);

            return;
        }

        Assertions.assertThat(RacingInputHandler.splitCarNames(carNames))
                .isEqualTo(expected.split(","));
    }

    @DisplayName("tryCntToInt test")
    @ParameterizedTest(name = "인자가 {0}일 때, {3}")
    @CsvSource({
            "'1', false, 1, '예외 발생 없이 올바르게 변환'",
            "' 0 ', false, 0, '예외 발생 없이 올바르게 변환'",
            "'1001', true, 1001, '1000보다 크므로 예외 발생'",
            "'d103', true, 0, '숫자만으로 이루어지지 않았으므로 예외 발생'",
            "'-1', true, 0, '숫자만으로 이루어지지 않았으므로 예외 발생'"
    })
    public void tryCntToIntTest(String num, boolean exception, int expected, String testMsg) {
        if (exception) {
            Assertions.assertThatThrownBy(() -> {
                RacingInputHandler.tryCntToInt(num);
            })
                    .isInstanceOf(IllegalArgumentException.class);

            return;
        }

        Assertions.assertThat(RacingInputHandler.tryCntToInt(num))
                .isEqualTo(expected);
    }
}
