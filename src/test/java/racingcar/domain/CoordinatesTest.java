package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinatesTest {

    @DisplayName("좌표를 생성하고 숫자를 기입하여 반환받는다.")
    @Test
    void generate() {
        // given & when
        Coordinates coordinates = Coordinates.generate(4, 7, 8);
        int num1 = coordinates.pop();
        int num2 = coordinates.pop();
        int num3 = coordinates.pop();

        // then
        assertThat(num1).isEqualTo(4);
        assertThat(num2).isEqualTo(7);
        assertThat(num3).isEqualTo(8);
    }

    @DisplayName("좌표를 세팅 후, 범주를 넘어가게 pop 실행시 IllegalArgumentException발생")
    @Test
    void pop() {
        // given & when
        Coordinates coordinates = Coordinates.generate();
        coordinates.setCoordinates(2);
        coordinates.pop();
        coordinates.pop();

        // then
        assertThatThrownBy(() -> {
            coordinates.pop();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
