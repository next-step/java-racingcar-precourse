package racingcar.model.laps;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LapsTest {
    @Test
    void 변환_문자열() {
        assertThat(Laps.of("123").get()).isEqualTo(123);
    }

    @Test
    void 변환_숫자() {
        assertThat(Laps.of(123).get()).isEqualTo(123);
    }

    @Test
    void 호출했냐() {

    }
}
