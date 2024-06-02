import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    //Test: 자동차 이름 입력 및 유효성 검사 테스트
    @Test
    // 공백 Test
    void carNameShouldNotBeEmpty() {
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1자 이상 5자 이하만 가능합니다.");
    }
    @Test
    void carNameShouldNotBeLongerThanFiveCharacters() {
        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1자 이상 5자 이하만 가능합니다.");
    }
    @Test
    void carNameShouldOnlyContainEnglishCharacters() {
        assertThatThrownBy(() -> new Car("자동차"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("영문자만 가능합니다.");
    }
    @Test
    void carNameShouldNotContainSpaces() {
        assertThatThrownBy(() -> new Car("car "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백이 포함될 수 없습니다.");
    }
    //Test: 자동차 이동 로직 테스트
    @Test
    void carShouldMoveWhenRandomNumberIsGreaterThanOrEqualToFour() {
        Car car = new Car("Car");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
