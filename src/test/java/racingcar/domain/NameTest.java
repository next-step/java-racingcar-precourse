package racingcar.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 이름 관련 기능")
class NameTest {
    @DisplayName("자동차 이름을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void create(String carName) {
        // when
        Name name = Name.from(carName);

        // then
        assertThat(name).hasToString(carName);
    }

    @DisplayName("자동차 이름을 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    @EmptySource
    @NullSource
    void invalid(String carName) {
        // when
        ThrowingCallable throwingCallable = () -> Name.from(carName);

        // then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Name.INVALID_NAME_LENGTH_MESSAGE);
    }
}
