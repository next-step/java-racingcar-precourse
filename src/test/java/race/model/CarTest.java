package race.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.exception.LengthLimitException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차 이름이 제한된 길이를 넘어가면 오류가 발생되는 지 테스트")
    void test_exceedNameLength() {
        // given
        String exceedLengthName = "aaaaaa";

        // when, then
        assertThatThrownBy(() -> new Car(exceedLengthName))
                .isInstanceOf(LengthLimitException.class);
    }
}