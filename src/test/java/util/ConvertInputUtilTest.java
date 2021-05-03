package util;

import constant.GameErrorCode;
import exception.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConvertInputUtilTest {

    @DisplayName("자동차 이름 입력_성공")
    @ParameterizedTest
    @CsvSource({
            "pobi, 1",
            "'pobi,crong,honux', 3"
    })
    void TEST_getCarNameFromInput_Success(String name, int num) {
        assertThat(ConvertInputUtil.getCarNameFromInput(name)).hasSize(num);
    }

    @DisplayName("자동차 이름 입력_실패")
    @ParameterizedTest
    @CsvSource({
            "'', CAR_NAME_EMPTY",
            "aaaaaa, CAR_NAME_SIZE_OVER",
            "'pobi,pobi', CAR_NAME_OVERLAP"
    })
    void TEST_getCarNameFromInput_Fail(String name, String error) {
        Throwable exception = assertThrows(GameException.class, () -> ConvertInputUtil.getCarNameFromInput(name));
        assertThat(exception.getMessage()).isEqualTo(GameErrorCode.valueOf(error).getMsg());
    }

    @DisplayName("시도 횟수 입력_성공")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10"})
    void TEST_getCarNameFromInput_Success(String tryNum) {
        assertThat(ConvertInputUtil.getTryNumberFromInput(tryNum)).isEqualTo(Integer.parseInt(tryNum));
    }

    @DisplayName("시도 횟수 입력_실패")
    @ParameterizedTest
    @ValueSource(strings = {"", "abc"})
    void TEST_getTryNumberFromInput_Fail(String tryNum) {
        Throwable exception = assertThrows(GameException.class, () -> ConvertInputUtil.getTryNumberFromInput(tryNum));
        assertThat(exception.getMessage()).isEqualTo(GameErrorCode.TRY_NUMBER_PARSING.getMsg());
    }
}
