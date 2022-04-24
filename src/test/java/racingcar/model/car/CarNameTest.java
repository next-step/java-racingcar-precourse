package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차의 이름은 1~5자 여야한다.")
    @ValueSource(strings = {"", "abcdef"})
    public void 자동차_이름_유효성검사(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(input));
    }

    @Test
    @DisplayName("자동차의 이름 객체 생성 확인")
    public void 자동차_이름_객체_생성_확인() {
        String testCarName = "Test1";
        CarName carName = new CarName(testCarName);
        assertEquals(carName.getName(), testCarName);
    }

}
