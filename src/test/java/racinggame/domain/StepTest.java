package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @ParameterizedTest
    @CsvSource(value = {"2,'--'", "1,'-'", "0,''"})
    void makeStepMessage_success(int num, String dash) {
        assertThat(new Step(num).makeStepMessage()).isEqualTo(new Message(dash));
    }
}