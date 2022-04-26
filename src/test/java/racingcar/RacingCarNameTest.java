package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RacingCarNameTest {

    @Test
    void 이름_5글자() {
        RacingCarName racingCarName = new RacingCarName("sae");

        assertThat(racingCarName.getValue()).isEqualTo("sae");
    }

    @Test
    void 이름_5글자_이상() {
        assertThatThrownBy(() -> new RacingCarName("saerang"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 넘길 수 없습니다.");
    }
}
