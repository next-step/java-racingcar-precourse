package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarPositionTest {
    @ParameterizedTest
    @ValueSource(ints = {-2, -1})
    void 차의_위치는_음수_일_수_없다(int position) {
        assertThatCode(() -> new CarPosition(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 위치값은 0 이상 이어야 합니다.");
    }

    @Test
    void CarPosition_생성_시_위치값을_전달하지_않을경우_초기값은_0이다() {
        assertThat(new CarPosition()).isEqualTo(new CarPosition(0));
    }

    @Test
    void 차의_위치가_같을_경우_equals_는_True() {
        assertThat(new CarPosition(1)).isEqualTo(new CarPosition(1));
    }

    @Test
    void 차의_위치가_다를_경우_equals_는_False() {
        assertThat(new CarPosition(1)).isNotEqualTo(new CarPosition(2));
    }

    @Test
    void 앞으로_전진_할_경우_차의_위치가_증가한다() {
        CarPosition carPosition = new CarPosition();
        CarPosition movedCarPosition = carPosition.moveForward();
        assertThat(movedCarPosition).isEqualTo(new CarPosition(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---", "4:----", "5:-----"}, delimiter = ':')
    void CarPosition_의_toString_호출시_위치만큼_하이픈이_출력(int position, String expectedHyphenString) {
        assertThat(new CarPosition(position).toString()).isEqualTo(expectedHyphenString);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:4:-1", "3:3:0", "4:3:1"}, delimiter = ':')
    void CarPosition_을_비교_할_수_있다(int position1, int position2, int expectedValue) {
        CarPosition sunPosition = new CarPosition(position1);
        CarPosition yangPosition = new CarPosition(position2);
        assertThat(sunPosition.compareTo(yangPosition)).isEqualTo(expectedValue);
    }
}