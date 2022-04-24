package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {
    @Test
    void RandomNumber_생성() {
        assertThat(RandomNumber.of(1)).isEqualTo(RandomNumber.of(1));
    }

    @Test
    void 예외테스트_음수인경우() {
        assertThatThrownBy(() -> RandomNumber.of(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외테스트_범위초과인경우() {
        assertThatThrownBy(() -> RandomNumber.of(99)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 갈수_없는_숫자인지확인() {
        assertThat(RandomNumber.of(1).isOver(4)).isEqualTo(false);
    }

    @Test
    void 갈수_있는_숫자인지확인() {
        assertThat(RandomNumber.of(9).isOver(4)).isEqualTo(true);
    }
}
