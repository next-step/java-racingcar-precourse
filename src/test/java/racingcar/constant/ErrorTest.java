package racingcar.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ErrorTest {
    @DisplayName("모든 에러 메시지는 [ERROR] 메시지를 포함한다")
    @Test
    void 에러메시지_문자열_포함_테스트() {
        for (Error error : Error.values()) {
            assertThat(error.toString()).contains("[ERROR]");
        }
    }
}
