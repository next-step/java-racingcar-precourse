package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.common.ErrorMessage.*;


public class InputUtilTest {

    private InputUtil inputUtil;

    @BeforeEach
    void setUp() {
        inputUtil = InputUtil.getInstance();
    }

    @Test
    @DisplayName("문자열 자르기 테스트")
    void splitTest() {
        String input = "java,poni, woni";
        List<String> splitInputs = inputUtil.split(input);
        assertThat(splitInputs.size()).isEqualTo(3);
        assertThat(splitInputs.get(0)).isEqualTo("java");
        assertThat(splitInputs.get(1)).isEqualTo("poni");
        assertThat(splitInputs.get(2)).isEqualTo("woni");
    }

    @Test
    @DisplayName("문자열 자르기 실패 테스트")
    void splitFailTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    String emptyInput = " ";
                    inputUtil.split(emptyInput);
                }).withMessage(EMPTY_INPUT.text());
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    inputUtil.split(null);
                }).withMessage(EMPTY_INPUT.text());
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    String tooLongInput = "javajigi, test";
                    inputUtil.split(tooLongInput);
                }).withMessage(NAME_TO_LONG.text());
    }

    @Test
    @DisplayName("문자열 숫자로 변환 테스트")
    void parseTest() {
        assertThat(inputUtil.parse("3")).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 숫자로 변환 실패 테스트")
    void parseFailTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    inputUtil.parse("-1");
                }).withMessage(NOT_NUMERIC.text());
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    inputUtil.parse("1test");
                }).withMessage(NOT_NUMERIC.text());
    }
}