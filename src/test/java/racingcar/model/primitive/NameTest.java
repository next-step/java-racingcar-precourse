package racingcar.model.primitive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.primitive.Name;

class NameTest {

    @ParameterizedTest
    @CsvSource(value = {"value1", "value2", "Jennifer"})
    @DisplayName("5글자 이상 이름은 입력불가")
    void nameLengthExceptionTest(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource(value = {"Jay, Jay","Kayln, Kayln", "김도, 김도", "김C, 김C"})
    void checkNameCreationAndCheckValue(String input, String expected) {
        Name name = new Name(input);
        assertThat(name.getName()).isEqualTo(expected);
    }
}