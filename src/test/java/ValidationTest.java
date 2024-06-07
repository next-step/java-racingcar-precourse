import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import controller.Validation;

public class ValidationTest {

    @DisplayName("자동차 이름이 5자 이상인 경우 예외 발생")
    @Test
    public void carNamesTest1() {
        // given
        String[] carNames = {"pobi", "woniii", "jun"};

        // when

        // then
        assertThatThrownBy(() -> Validation.checkCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 영문이 아닌 경우 예외 발생")
    @Test
    public void carNamesTest2() {
        // given
        String[] carNames = {"pobi", "woni2", "jun"};

        // when

        // then
        assertThatThrownBy(() -> Validation.checkCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 공백인 경우 예외 발생")
    @Test
    public void carNamesTest3() {
        // given
        String[] carNames = {"pobi", "", "jun"};

        // when

        // then
        assertThatThrownBy(() -> Validation.checkCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 띄어쓰기가 있는 경우 예외 발생")
    @Test
    public void carNamesTest4() {
        // given
        String[] carNames = {"pobi", "wo ni", "jun"};

        // when

        // then
        assertThatThrownBy(() -> Validation.checkCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 중복되는 경우 예외 발생")
    @Test
    public void carNamesTest5() {
        // given
        String[] carNames = {"pobi", "pobi", "jun"};

        // when

        // then
        assertThatThrownBy(() -> Validation.checkCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 MAX 보다 많은 경우 예외 발생") // MAX = 5
    @Test
    public void carNamesTest6() {
        // given
        String[] carNames = {"pobi", "woni", "jun", "ryan", "frodo", "neo"};

        // when

        // then
        assertThatThrownBy(() -> Validation.checkCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 정수가 아닌 경우 예외 발생")
    @Test
    public void numberTest1() {
        // given
        String number = "a";

        // when

        // then
        assertThatThrownBy(() -> Validation.checkNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 1 보다 작은 경우 예외 발생")
    @Test
    public void numberTest2() {
        // given
        String number = "0";

        // when

        // then
        assertThatThrownBy(() -> Validation.checkNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 MAX 보다 큰 경우 예외 발생") // MAX = 10
    @Test
    public void numberTest3() {
        // given
        String number = "11";

        // when

        // then
        assertThatThrownBy(() -> Validation.checkNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
