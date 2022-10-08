package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesTest {
    @Test
    void 문자열을_통해_CarNames_를_생성_할_수_있다() {
        String names = "pobi,sun";
        assertThatCode(() -> new CarNames(names)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "pobi,sun,pobi"})
    void 차의_이름은_중복될_수_없다(String enteredFromUser) {
        assertThatCode(() -> new CarNames(enteredFromUser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 차의_이름_중_5글자를_초과하는_이름이_있을경우_예외가_발생한다() {
        assertThatCode(() -> new CarNames("pobiii, sun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 차의_이름_중_공백으로_된_이름이_있을경우_예외가_발생한다() {
        assertThatCode(() -> new CarNames("pobi, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 공백일 수 없습니다.");
    }
}