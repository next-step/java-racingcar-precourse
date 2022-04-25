package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.model.exception.OverMaxNameLengthException;
import racingcar.model.exception.NullOrBlankException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("생성자로 name 문자열을 넘기면 toString() 시 name 문자열을 리턴한다.")
    void toStringNameString() {
        assertThat(new Name("ssam").toString()).isEqualTo("ssam");
    }

    @Test
    @DisplayName("이름이 5자 초과하면 예외가 발생한다")
    void nameMaxLengthException() {
        assertThatThrownBy(() -> new Name("ssamza"))
                .isInstanceOf(OverMaxNameLengthException.class);
    }

    @ParameterizedTest
    @DisplayName("이름이 공백이거나 null 이면 예외가 발생한다")
    @NullAndEmptySource
    void 이름_공백시_예외발생(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(NullOrBlankException.class);
    }
}
