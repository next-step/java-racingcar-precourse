package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"hello", ",hi", "hi,"})
    @DisplayName("경주를 위해서 입력받은 자동차 이름이 2개 미만으로 입력되면 예외가 발생한다.")
    void contructor_경주를_위한_자동차_이름_입력값_최소_2개이상(String name) {
        Assertions.assertThatThrownBy(() -> new CarNames(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주를 위해서 입력받은 자동차 이름은 최소 2개이상이면 정상 생성된다.")
    void contructor_경주를_위한_자동차_이름의_수가_2개이상이면_정상() {
        // given
        String name = "java,jdk";
        // when
        CarNames carNames = new CarNames(name);
        // then
        Assertions.assertThat(carNames.getCarNames()).hasSize(2);
    }

    @ValueSource(strings = {"jdk,jdk,jdk", "wow,cafe,jdk,cafe", "aaa,aaa,bbb,ccc"})
    @DisplayName("자동차 이름에 중복이 있으면 예외가 발생한다.")
    @ParameterizedTest
    void constructor_자동차_이름에_중복이_있으면_예외(String name) {
        Assertions.assertThatThrownBy(() -> new CarNames(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값에 구분자가 입력되지 않으면 예외발생한다.")
    void contructor_입력값에_구분자가_입력되지_않으면_예외() {
        // given
        String name = "wow;hello;hi";
        // when, then
        Assertions.assertThatThrownBy(() -> new CarNames(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값에 Blank가 있는 경우 예외 발생")
    void constructor_입력값에_BLANK가_있는_경우_예외() {
        // given
        String name = "wow,hello,hi, ,  ";
        // when, then
        Assertions.assertThatThrownBy(() -> new CarNames(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}