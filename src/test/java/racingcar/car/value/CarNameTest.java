package racingcar.car.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @ParameterizedTest(name = "{displayName} input: \"{0}\"")
    @DisplayName("자동차 이름의 길이는 1이상 5이하만 가능하다.")
    @ValueSource(strings = {"", "123456"})
    void nameLengthOverFive(String name){
        assertThatThrownBy(() -> {
            new CarName(name);
        }).hasMessageContaining(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    @DisplayName("이름이 같으면 같은객체")
    void sameNameIsEqual(){
        final String name = "name";
        CarName cn1 = new CarName(name);
        CarName cn2 = new CarName(name);

        assertThat(cn1).isEqualTo(cn2);
    }
}