package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {
    @DisplayName("라운드 초기화 테스트")
    @Test
    public void roundInitTest() {
        Round round = Round.valueOf("5");
        assertThat(round.getRound()).isEqualTo(5);
    }

    @DisplayName("라운드 음수값 테스트")
    @Test
    public void roundNegativeTest() {
        assertThatIllegalStateException()
                .isThrownBy(() -> Round.valueOf("-4"));
    }

    @DisplayName("라운드 문자값 테스트")
    @Test
    public void roundNotNumberTest() {
        assertThatIllegalStateException()
                .isThrownBy(() -> Round.valueOf("-4"));
    }

    @DisplayName("라운드 빈문자값 테스트")
    @Test
    public void roundBlankTest() {
        assertThatIllegalStateException()
                .isThrownBy(() -> Round.valueOf("-4"));
    }
}
