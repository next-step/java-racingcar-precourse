package racingcar.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void 자동차_기본생성자_검증_테스트() {
        assertThatThrownBy(Cars::new)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 경주 할 자동차 이름 입력값이 존재하지 않습니다.");
    }

    @Test
    void 자동차_이름_검증_테스트() {
        assertThatThrownBy(() -> new Cars("pobi,crong,honux,javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 경주 할 자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_중복_검증_테스트() {
        assertThatThrownBy(() -> new Cars("pobi,crong,pobi,honux"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 경주 할 자동차 이름은 중복 될 수 없습니다.");
    }
}
