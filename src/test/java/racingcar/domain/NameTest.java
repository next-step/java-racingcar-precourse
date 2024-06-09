package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("이름 테스트")
public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"woni", "pobi", "jun", "jason"})
    void 이름_생성(final String value) {
        Name name = new Name(value);

        Assertions.assertThat(name).isEqualTo(new Name(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"eleven", "abcdefg"})
    void 이름이_5자_초과면_에러를_반환한다(final String value) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Name(value));
    }
}
