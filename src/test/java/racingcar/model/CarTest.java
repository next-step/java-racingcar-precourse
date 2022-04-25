package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @DisplayName("Car 생성")
    @Test
    public void create() {
        Car min = new Car("a");
        Car max = new Car("abcde");
    }

    @DisplayName("Car 생성 예외 : 5자 이하 (공백 금지)")
    @Test
    public void create_invalid_size() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진 : 주행거리 증가")
    @Test
    public void move() {
        // given
        Car min = new Car("a");
        Car max = new Car("b");

        // when/then
        min.moveTest(4);
        assertThat(min.getMileage()).isEqualTo(1);
        assertThat(min.isMoved()).isEqualTo(true);

        max.moveTest(9);
        assertThat(max.getMileage()).isEqualTo(1);
        assertThat(max.isMoved()).isEqualTo(true);
    }
    
    @DisplayName("전진 : 주행거리 변화없음")
    @Test
    public void not_move() {
        // given
        Car min = new Car("a");
        Car max = new Car("b");

        // when/then
        min.moveTest(1);
        assertThat(min.getMileage()).isEqualTo(0);
        assertThat(min.isMoved()).isEqualTo(false);

        max.moveTest(3);
        assertThat(max.getMileage()).isEqualTo(0);
        assertThat(max.isMoved()).isEqualTo(false);
    }
}