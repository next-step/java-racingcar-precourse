package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author SeongRok.Oh
 * @since 2022/10/10
 */
public class RacerTest {

    @DisplayName("Racer 이름 검증 테스트")
    @ValueSource(strings = {"홍길동", "우승자", "장동건", "원빈", "생성자"})
    @ParameterizedTest
    void createTest(String input) {
        Racer racer = Racer.from(input);
    }

    @DisplayName("다섯글자 이상 Racer 이름 생성")
    @Test
    void createLengthErrorTest() {
        String name = "다섯자이상이다아";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Racer.from(name))
                .withMessageContaining(PrintMessage.NAME_OUT_OF_LENGTH_ERROR.getMessage());
    }

    @DisplayName("비어있는 Racer 이름 생성")
    @Test
    void createEmptyErrorTest() {
        String name = "";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Racer.from(name))
                .withMessageContaining(PrintMessage.NAME_EMPTY_ERROR.getMessage());
    }
}
