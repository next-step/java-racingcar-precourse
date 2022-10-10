package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @DisplayName("입력된 자동차 대수가 1대 이하인 경우 예외처리")
    @Test
    void 입력된_자동차_대수가_1대_이하인_경우() {
        assertThatThrownBy(() -> new RacingGame("pobi,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 2대 이상 입력해주세요.");
    }

    @DisplayName("입력된 자동차 이름이 중복인 경우 예외처리")
    @Test
    void 입력된_자동차_이름이_중복인_경우() {
        assertThatThrownBy(() -> new RacingGame("pobi, crong, honux, pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("자동차 이름 쉼표(,) 구분 테스트")
    @Test
    void 자동차_이름_쉼표_구분() {
        assertThatThrownBy(() -> new RacingGame("pobi crong honux"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표(,)로 구분해 주세요.");
    }
}
