package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 이름_생성(final String name) {
        assertThat(new Name(name).getValue()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobicronghonux"})
    void 예외테스트_잘못된_이름_생성(final String name) {
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}