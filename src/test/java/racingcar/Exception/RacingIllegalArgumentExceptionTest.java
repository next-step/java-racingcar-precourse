package racingcar.Exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingIllegalArgumentExceptionTest {
    @Test
    void 예외_메세지_테스트() {
        // given
        try {
            // when
            throw new RacingIllegalArgumentException("test");
        } catch (Exception e) {
            // then
            assertThat(e.getMessage()).contains("[ERROR] test");
        }
    }
}