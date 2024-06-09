package app.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarGameTest {

    @Test
    @DisplayName("5자리 이상 자동차 이름이 입력됐을 경우")
    void test1() {
        String inputCarNames = "가나,다라마바,사아자차카타,파하";

        assertThatThrownBy(() -> {
            RacingCarGame racingCarGame = new RacingCarGame();
            racingCarGame.setCarList(inputCarNames);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자리 이상 5자리 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 입력됐을 경우")
    void test2() {
        String inputCarNames1 = "";

        assertThatThrownBy(() -> {
            RacingCarGame racingCarGame = new RacingCarGame();
            racingCarGame.setCarList(inputCarNames1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자리 이상 5자리 이하만 가능합니다.");

        String inputCarNames2 = "가나,다라마,,바사";

        assertThatThrownBy(() -> {
            RacingCarGame racingCarGame = new RacingCarGame();
            racingCarGame.setCarList(inputCarNames2);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자리 이상 5자리 이하만 가능합니다.");
    }

    @Test
    @DisplayName("시도 회수에 숫자 외 문자가 입력됐을 경우")
    void test3() {
        String input = "asd@34";

        assertThatThrownBy(() -> {
            RacingCarGame racingCarGame = new RacingCarGame();
            racingCarGame.setAttemptCnt(input);
        })
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("시도 회수에 1 미만 숫자가 입력됐을 경우")
    void test4() {
        String input1 = "-1";

        assertThatThrownBy(() -> {
            RacingCarGame racingCarGame = new RacingCarGame();
            racingCarGame.setAttemptCnt(input1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 1 이상이어야 합니다.");

        String input2 = "0";

        assertThatThrownBy(() -> {
            RacingCarGame racingCarGame = new RacingCarGame();
            racingCarGame.setAttemptCnt(input2);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 회수는 1 이상이어야 합니다.");
    }
}
