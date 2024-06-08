import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void shouldThrowExceptionWhenCarNameExceedsFiveCharacters() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    public void shouldMoveCarWhenRandomValueIsFourOrGreater() {
        Car car = new Car("pobi");
        car.move(4); // 4 이상
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void shouldNotMoveCarWhenRandomValueIsLessThanFour() {
        Car car = new Car("pobi");
        car.move(3); // 3 이하
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
