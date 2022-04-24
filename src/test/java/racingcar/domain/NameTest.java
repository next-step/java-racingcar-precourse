package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void 정상적인_이름_생성규칙_테스트(String name) {
        Name carName = new Name(name);
        assertThat(carName.getValue()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"yangname"})
    void 이름이_5글자를_초과하면_예외발생(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름은 5자리 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ",""})
    void 이름은_빈값이_올수없음(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름은 빈 값이 올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void 이름_비교는_동등성확인(String name) {
        assertThat(new Name(name)).isEqualTo(new Name(name));
    }

}
