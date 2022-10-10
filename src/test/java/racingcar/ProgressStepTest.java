package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ProgressStepTest {

    @Test
    void 올바른_시도횟수인가_test() {
        ProgressStep progressStep = new ProgressStep(new StepNumberString("5"));
        assertThat(progressStep.isCollectStepNumber()).isTrue();
    }

    @Test
    void 잘못된_시도횟수_입력시_익셉션_test() {
        ProgressStep progressStep = new ProgressStep(new StepNumberString("a"));
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            progressStep.isCollectStepNumber();
        });
    }
}
