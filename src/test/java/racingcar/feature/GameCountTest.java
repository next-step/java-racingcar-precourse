package racingcar.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameCountTest {

    @DisplayName("게임 횟수 - 게임 횟수 생성")
    @Test
    void createGameCountTest() {
        //given:
        String input = "3";
        GameCount gameCount;
        //when:
        gameCount = new GameCount(input);
        //then:
        assertThat(gameCount.getCount())
                .isEqualTo(3);
    }

    @DisplayName("게임 횟수 - 예외 - 숫자가 아닌 문자열 입력")
    @Test
    void parseNumberExceptionTest() {
        //given:
        String input = "notNumber";
        RuntimeException exception = new RuntimeException();
        //when:
        try {
            new GameCount(input);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        //then:
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 횟수를 정확히 입력해 주세요");
    }
}
