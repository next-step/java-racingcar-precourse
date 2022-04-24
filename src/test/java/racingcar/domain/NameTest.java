package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.common.Message;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @ParameterizedTest
    @DisplayName("자동차_이름_공백_체크")
    @ValueSource(strings = { "", " ", "    " })
    void 자동차_이름_공백_체크(String name) {
        assertThatThrownBy(() -> {
            new Name(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_CAR_NAME_EMPTY);
    }

    @ParameterizedTest
    @DisplayName("자동차_이름_길이_체크")
    @ValueSource(strings = { "pobise", "wonini", "joseph", "toyotiiii" })
    void 자동차_이름_길이_체크(String name) {
        assertThatThrownBy(() -> {
            new Name(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_CAR_NAME_LENGTH);
    }
}
