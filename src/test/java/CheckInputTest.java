import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckInputTest {

    @Test
    @DisplayName("자동차 이름 중복 되는 경우 예외처리 테스트")
    public void carNameShouldNotExceedFiveCharacters() {
        assertThatThrownBy(() -> new Car("sixletters"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }
    /*public void checkCarNames_InvalidInput() {
        List<String> carNames = new ArrayList<>(Arrays.asList("abc", "abc", "ghi"));

        // IllegalStateException 예외 발생 확인
        assertThatThrownBy(() -> CheckInput.checkCarNames(carNames))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 자동차의 이름은 모두 다르게 입력해주세요.");
    }*/

}
