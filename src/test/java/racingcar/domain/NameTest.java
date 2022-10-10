package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름은 5자 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"n", "na", "nam", "name", "names"})
    void nameLengthValid(String inputName) {

        Name name = new Name(inputName);
        assertThat(name).isInstanceOf(Name.class);
    }


    @DisplayName("이름이 5자 이상이면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"KimChu", "KimChul", "KimChulS"})
    void nameLengthValidException(String inputName) {

        assertThatThrownBy(() -> new Name(inputName)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("이름이 비어있으면 에러가 발생한다.")
    @Test
    void nameEmptyValid() {

        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 이름으로 출력된다.")
    @ParameterizedTest
    @ValueSource(strings = {"n", "na", "nam", "name", "names"})
    void namePrint(String inputName) {

        Name name = new Name(inputName);
        assertThat(name.toString()).isEqualTo(inputName);
    }
}
