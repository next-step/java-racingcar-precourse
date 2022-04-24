package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.NameMessage;

class NameTest {

    @Test
    @DisplayName("5자 이하의 이름으로 단일 값을 입력 받는다")
    void inputValidName() {
        Name mond = Name.valueOf("mond");

        assertAll(
                () -> assertThat(mond).isNotNull(),
                () -> assertThat(mond.getName()).isEqualTo("mond")
        );
    }

    @ParameterizedTest(name = "이름값({0})이 공백이거나 아예 비어있다")
    @ValueSource(strings = {"", " ", "\n"})
    void inputInvalidNameEmpty(String name) {
        assertThatThrownBy(() -> Name.valueOf(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameMessage.INVALID_NAME_LENGTH);
    }

    @Test
    @DisplayName("이름이 5자를 넘어선다")
    void inputInvalidNameLengthOver() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Name.valueOf("banana"))
                .withMessage(NameMessage.INVALID_NAME_LENGTH);
    }
}
