package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ValidationUtils.ERROR_MESSAGE;
import static racingcar.ValidationUtils.makeSplitedArray;

public class ValidationUtilsTest {

    private String inputCarNames;
    private String inputTryCnt;

    @Test
    @DisplayName("자동차 이름 입력값 검증 성공 테스트")
    void inputCarNamesTest(){
        inputCarNames = "pobi,woni,java";
        String[] carNames = makeSplitedArray(inputCarNames);
        assertThat(carNames.length).isEqualTo(3);
        assertThat(ValidationUtils.validateCarNames(carNames).length).isEqualTo(carNames.length);
    }

    @Test
    @DisplayName("자동차 이름 입력값 검증 실패 테스트")
    void inputCarNamesErrorTest(){
        inputCarNames = "pobi,woni,javajigi";
        assertThatThrownBy(() -> ValidationUtils.validateCarNames(makeSplitedArray(inputCarNames))).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("횟수 입력값 검증 성공 테스트")
    void inputTryCntTest(){
        inputTryCnt = "5";
        assertThat(ValidationUtils.isValidCnt(inputTryCnt)).isEqualTo(Integer.parseInt(inputTryCnt));
    }

    @Test
    @DisplayName("횟수 입력값 검증 실패 테스트")
    void inputTryCntErrorTest(){
        inputTryCnt = "5555|$$5";
        assertThatThrownBy(() -> ValidationUtils.isValidCnt(inputTryCnt)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
