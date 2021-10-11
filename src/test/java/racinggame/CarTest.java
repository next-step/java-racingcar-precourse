package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("이름 길이 검증")
    void 이름이_5자_이하인가() {
        int carNameSize = car.getName().length();
        assertThat(carNameSize <= 5).isEqualTo(true);
        Car car2 = new Car("abcdefg");
        int carNameSize2 = car2.getName().length();
        assertThat(carNameSize2 <= 5).isEqualTo(false);
    }

    @Test
    @DisplayName("이동값 길이 검증")
    void 이동값이_0_9사이의_수_인가() {
        assertThat(car.isValidNumber(-1)).isEqualTo(false);
        assertThat(car.isValidNumber(10)).isEqualTo(false);
        assertThat(car.isValidNumber(0)).isEqualTo(true);
        assertThat(car.isValidNumber(9)).isEqualTo(true);
    }

    @Test
    @DisplayName("이동값이 4 이상일 경우 검증")
    void 이동값이_4_이상일_경우_전진한다() {
        int advance = car.racing(4);
        assertThat(advance).isEqualTo(1);
    }

    @Test
    @DisplayName("이동값이 3 이하일 경우 검증")
    void 이동값이_3_이하일_경우_멈춘다() {
        int advance = car.racing(3);
        assertThat(advance).isEqualTo(0);
    }

    @Test
    @DisplayName("이동값이 0~9 가 아닐 경우 검증")
    void 이동값이_0_9_사이의_수가_아닐_경우_에러() {
        assertThatThrownBy(() -> {
            car.racing(-1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이동할 숫자는 0부터 9의 값이어야 합니다.");
    }
}
