package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ui.AttemptCountEmptyException;
import racingcar.exception.ui.AttemptCountTypeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptCountTest {

    @Test
    @DisplayName("시도 횟수가 빈 값일 경우 예외 발생")
    void emptyAttemptCount(){
        assertThatThrownBy(() ->{
            new AttemptCount("");
        }).isInstanceOf(AttemptCountEmptyException.class)
                .hasMessageContaining("시도 횟수를 숫자로 입력해주세요");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외 발생")
    void noMatchTypeAttemptCount(){
        assertThatThrownBy(() ->{
            new AttemptCount("문자열");
        }).isInstanceOf(AttemptCountTypeException.class)
                .hasMessageContaining("시도 횟수는 숫자여야합니다.");
    }

    @Test
    @DisplayName("시도 횟수 확인")
    void getAttemptCount(){
        AttemptCount attemptCount = new AttemptCount("1");
        assertThat(attemptCount.getAttemptCount()).isEqualTo(1);
    }

}
