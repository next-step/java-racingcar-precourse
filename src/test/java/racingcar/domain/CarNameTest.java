package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @DisplayName("이름이 5자가 넘을 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"six666", "seven77"})
    void nameLengthOver(String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 정상적으로 생성")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    void nameLengthSuccess(String name) {
        CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name);
    }
}