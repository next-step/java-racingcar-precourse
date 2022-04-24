package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.NameMessage;

class NamesTest {

    @ParameterizedTest(name = "5자 이하의 이름으로 2개 이상의 값({0})을 입력 받는다")
    @ValueSource(strings = {"mond,latte,bana", "apple, pink, choco"})
    void inputValidNames(String names) {
        assertThat(Names.valueOf(names)).isNotNull();
    }

    @ParameterizedTest(name = "구분자({0})만 입력 받는다")
    @ValueSource(strings = {",", ",,"})
    void inputInvalidNamesOnlySeparatorCharacter(String names) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Names.valueOf(names))
                .withMessage(NameMessage.EMPTY_INPUT_NAMES);
    }

    @ParameterizedTest(name = "공백({0})만 입력 받는다")
    @ValueSource(strings = {" ", "\n"})
    void inputInvalidNamesOnlyEmptyString(String names) {
        assertThatThrownBy(() -> Names.valueOf(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameMessage.INVALID_NAME_LENGTH);
    }

    @ParameterizedTest(name = "구분자가 이름의 수보다 많거나 같다({0})")
    @ValueSource(strings = {",piano,mond", ",mond,latte,apple,"})
    void inputSeparatorMoreThenOrEqualToNames(String names) {
        assertThatThrownBy(() -> Names.valueOf(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameMessage.INVALID_NAME_LENGTH);
    }

    @ParameterizedTest(name = "중복된 이름이 존재한다.({0})")
    @ValueSource(strings = {"mond,choco,mond", "latte, bana, latte"})
    void inputInvalidNamesDuplicateName(String names) {
        assertThatThrownBy(() -> Names.valueOf(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameMessage.DUPLICATE_INPUT_NAME);
    }

    @Test
    @DisplayName("이름 중에 6글자인 이름이 포함되어 있다")
    void inputContainInvalidName() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Names.valueOf("mond,latte,gloria"))
                .withMessage(NameMessage.INVALID_NAME_LENGTH);
    }
}
