package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.game.Count;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountTest {

    @Test
    @DisplayName("생성자메소드 입력값검증에서 문자열이 null이면 예외발생")
    void throw_NullPointException_when_null() {
        //given
        String count = null;

        //when,then
        assertThatThrownBy(() -> new Count(count))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("[ERROR] 횟수가 존재하지 않습니다");
    }

    @Test
    @DisplayName("생성자메소드 입력값검증에서 문자열이 양수가 아니면 예외발생")
    void throw_IllegalArgumentException_when_not_number() {
        //given
        String count = "-123";

        //when,then
        assertThatThrownBy(() -> new Count(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 횟수는 0보다큰 수만 허용합니다");
    }

    @Test
    @DisplayName("생성자메소드 입력값검증에서 입력한수가 0이면면 예외발생")
    void throw_IllegalArgumentException_when_zero_number() {
        //given
        String count = "00";

        //when,then
        assertThatThrownBy(() -> new Count(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 횟수는 0보다큰 수만 허용합니다");
    }

    @Test
    @DisplayName("next메소드는 값이 count값이 0보다크면 true반환")
    void return_true_when_greater_than_0() {
        //given
        Count count = new Count("3");

        //when
        boolean hasNext = count.next();

        //then
        assertThat(hasNext).isEqualTo(true);
    }

    @Test
    @DisplayName("next메소드는 값이 count값이 0이면 false반환")
    void return_false_when_equals_0() {
        //given
        Count count = new Count("2");

        //when
        count.next();
        count.next();
        boolean hasNext = count.next();

        //then
        assertThat(hasNext).isEqualTo(false);
    }


}
