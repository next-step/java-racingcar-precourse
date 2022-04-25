package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    @DisplayName("생성할 때 전달한 자동차 이름을 출력 함수에서 사용할 때 이름을 출력하는지 검사한다")
    void checkStringOfCarNameOnceCarNameCreatedWithName() {
        String simple_name = "abc";
        CarName test_car = new CarName(simple_name);

        assertThat(test_car).hasToString(simple_name);
    }

    @Test
    @DisplayName("5자 이하 이름 규칙에 맞는 이름으로 자동자 이름을 생성하는지 검사한다")
    void createCarNameWithin5LettersName() {
        String fiveLetters = "abcde";

        CarName test_car = new CarName(fiveLetters);

        assertThat(test_car).hasToString(fiveLetters);
    }

    @Test
    @DisplayName("6자 이상으로 이름 규칙에 벗어난 이름으로 자동차 이름을 생성할때 예외를 발생하는지 검사한다")
    void throwIllegalArgumentExceptionIfCarNameWith6lettersMore() {
        String sixLetters = "abcdef";

        assertThatThrownBy(() -> {
            CarName test_car = new CarName(sixLetters);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
