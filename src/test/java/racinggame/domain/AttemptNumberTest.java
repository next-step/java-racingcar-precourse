package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptNumberTest {
    @DisplayName("시도 횟수 제대로 감소 이후 종료 상태 제대로 확인하는지 테스트")
    @Test
    void decrementAndIsOver_success() {
        AttemptNumber attemptNumber = new AttemptNumber(1);
        assertThat(attemptNumber.isOver()).isEqualTo(false);
        attemptNumber.decrement();
        assertThat(attemptNumber.isOver()).isEqualTo(true);
    }
}
