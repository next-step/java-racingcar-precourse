package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static view.MessageConstant.EXCEED_CAR_NAME_ERROR;

class CarNameTest {

    @ParameterizedTest
    @CsvSource({"a,su,tom,toby,david"})
    @DisplayName("자동차_이름_길이_검증")
    public void 자동차_이름_길이_검증(String name) {
        assertDoesNotThrow(() -> {
            new CarName(name);
        });
    }

    @ParameterizedTest
    @CsvSource({"potato,nextstep"})
    @DisplayName("자동차_이름_길이_검증_예외")
    public void 자동차_이름_길이_검증_예외(String name) {
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            new CarName(name);
        });
        assertThat(exceptionThrown.getMessage()).isEqualTo(EXCEED_CAR_NAME_ERROR);
    }

}