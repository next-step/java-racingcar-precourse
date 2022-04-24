package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class AttemptsTest {

    @Test
    void 숫자_아닌경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String readLine = "hwang";
            new Attempts(readLine);
        });
    }
}