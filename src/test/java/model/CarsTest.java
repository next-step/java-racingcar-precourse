package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차가_2대_미만이면_예외발생() {
        // given
        String[] names = "Kim".split(",");

        // when, then
        assertThatThrownBy(() -> new Cars(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 경주를 시작하려면 최소 2대 이상의 자동차가 필요합니다.");
    }

    @Test
    void 자동차_이름이_중복되면_예외발생() {
        // given
        String[] names = "Kim,Kim,Choi,Park".split(",");

        // when, then
        assertThatThrownBy(() -> new Cars(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 자동차의 이름은 중복될 수 없습니다.");
    }
}