package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameSplitterTest {
    @Test
    @DisplayName("자동차 이름 문자열을 배열로 나눈다.")
    void split() {
        // given
        String carNamesWithComma = "car1,car2,car3";

        // when
        String[] carNames = CarNameSplitter.split(carNamesWithComma);

        // then
        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @ParameterizedTest(name = "{displayName} message={0}")
    @ValueSource(strings = {"", " ", " ,car1", "car1, ", " , "})
    @DisplayName("잘못된 문자열을 입력하면 예외가 발생한다.")
    void createCarNameThrows(String value) {
        // given

        // when
        Executable executable = () -> CarNameSplitter.split(value);

        // then
        assertThrows(IllegalArgumentException.class, executable);
    }
}
