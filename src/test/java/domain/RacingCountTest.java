package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static view.MessageConstant.NOT_POSITIVE_NUMBER_ERROR;

class RacingCountTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 5, 10, 15, 30"})
    @DisplayName("시도_횟수_입력_테스트")
    public void 시도_횟수_입력_테스트(int count) {
        assertDoesNotThrow(() -> {
            new RacingCount(count);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"-10, -5, -1, 0"})
    @DisplayName("시도_횟수_입력_예외_테스트")
    public void 시도_횟수_입력_예외_테스트(int count) {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new RacingCount(count);
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo(NOT_POSITIVE_NUMBER_ERROR);
    }
}