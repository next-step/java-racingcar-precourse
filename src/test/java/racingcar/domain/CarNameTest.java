package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @DisplayName("자동차 이름이 빈 문자열일 경우 IllegalArgumentException이 발생한다.")
    @Test
    void carNameBlank() {
        // given
        String name = "";

        // when & then
        Assertions.assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5글자 초과할 경우 IllegalArgumentException이 발생한다.")
    @Test
    void carNameLimit() {
        // given
        String name = "1234567890";

        // when & then
        Assertions.assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("검증에 통과할 경우 자동차 이름이 성공적으로 등록된다.")
    @Test
    void generateSuccess() {
        // given
        String name = "mrlee";
        CarName carName = new CarName(name);

        // when & then
        Assertions.assertThat(carName.getName()).isEqualTo(name);
    }
}