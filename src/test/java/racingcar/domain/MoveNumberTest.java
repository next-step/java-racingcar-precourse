package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveNumberTest {
    @Test
    @DisplayName("전진_숫자_생성")
    void 전진_숫자_생성() {
        int number = MoveNumber.getRandomNumber();
        assertThat(Integer.toString(number).matches("[0-9]")).isTrue();
    }
}
