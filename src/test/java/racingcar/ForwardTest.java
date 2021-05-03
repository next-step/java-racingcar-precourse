package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardTest {

    @DisplayName("랜덤 값에 따라 전진 여부 결정 기능")
    @Test
    void forwardCondition() {
        Forward forward = new Forward();
        boolean isForward = forward.isForwardCondition();
        //assertThat(isForward).isFalse();
    }
}
