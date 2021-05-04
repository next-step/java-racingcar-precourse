package racingCar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름이 5글자를 초과하면 예외처리")
    @Test
    void car_length_contrain() {
        assertThatThrownBy(() -> new Car("jdragon", 0))
                .isInstanceOf(ExceedCarNameException.class)
                .hasMessage("자동차 이름의 길이가 5를 초과했습니다.");
    }

}