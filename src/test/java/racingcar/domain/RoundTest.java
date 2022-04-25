package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidParameterError;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Round 클래스 테스트 시작")
public class RoundTest {
    @Test
    @DisplayName("round를 문자열로 생성할 경우 오류 발생")
    public void checkRoundType() {
        assertThatThrownBy(() -> {
            new Round("a");
        }).isInstanceOf(InvalidParameterError.class).hasMessageContaining("[ERROR] 시도할 횟수에는 1~9만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("round를 0으로 생성할 경우 오류 발생")
    public void checkRoundZero() {
        assertThatThrownBy(() -> {
            new Round("0");
        }).isInstanceOf(InvalidParameterError.class).hasMessageContaining("[ERROR] 시도할 횟수에는 1~9만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("round를 2로 생성할 경우 통과")
    public void checkRound() {
        assertThat(new Round("2").getRound()).isEqualTo(2);
    }
}
