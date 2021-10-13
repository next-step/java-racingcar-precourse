package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.utils.Message;

class StepTest {
    @DisplayName("스텝 전진 제대로 작동하는지 확인")
    @Test
    void forward_success() {
        Step step = new Step(0);
        assertThat(step.makeStepMessage()).isEqualTo(new Message(""));

        step.forward();
        assertThat(step.makeStepMessage()).isEqualTo(new Message("-"));

        step.forward();
        assertThat(step.makeStepMessage()).isEqualTo(new Message("--"));
    }

    @DisplayName("스텝 메시지 생성 테스트")
    @Test
    void makeStepMessage_success() {
        assertThat(new Step(2).makeStepMessage()).isEqualTo(new Message("--"));
        assertThat(new Step(1).makeStepMessage()).isEqualTo(new Message("-"));
        assertThat(new Step(0).makeStepMessage()).isEqualTo(new Message(""));
    }
}