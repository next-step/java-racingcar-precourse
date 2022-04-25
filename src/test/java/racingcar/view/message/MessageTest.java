package racingcar.view.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MessageTest {
    private Message message = new Message();

    @DisplayName("자동차 이름 입력 요청")
    @Test
    void inputCarsNames() {
        //when
        String actual = message.inputCarsNames();

        //then
        assertThat(actual).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @DisplayName("시도 횟수 입력 요청")
    @Test
    void inputMoveCount() {
        //when
        String actual = message.inputMoveCount();

        //then
        assertThat(actual).isEqualTo("시도할 회수는 몇회인가요?");
    }

    @DisplayName("실행 결과 타이틀")
    @Test
    void resultTitle() {
        //when
        String actual = message.resultTitle();

        //then
        assertThat(actual).isEqualTo("실행 결과");
    }

    @DisplayName("자동차 이동 거리")
    @Test
    void moveDistance() {
        //given
        Distance distance = Distance.from(3);

        //when
        String actual = message.moveDistance("apple", distance);

        //then
        assertThat(actual).isEqualTo("apple : ---");
    }

    @DisplayName("최종 우승자")
    @Test
    void winners() {
        //given
        List<String> winners = Arrays.asList("pobi", "honux");

        //when
        String actual = message.winners(winners);

        //then
        assertThat(actual).isEqualTo("최종 우승자: pobi, honux");
    }

    @DisplayName("에러")
    @Test
    void error() {
        //given
        String errorMessage = "시도 회수는 숫자여야 한다.";

        //when
        String actual = message.error(errorMessage);

        //then
        assertThat(actual)
                .startsWith("[ERROR]")
                .containsOnlyOnce("[ERROR]");
    }
}