package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.InputMessageView.printInputCarNamesMessage;
import static racingcar.view.InputMessageView.printInputRacingRoundsMessage;

class InputMessageViewTest extends MessageViewTest {

    @Test
    @DisplayName("자동차 입력 안내 메시지가 정상적으로 출력되는지 확인한다.")
    void printInputCarNamesMessageTest() {
        printInputCarNamesMessage();

        assertThat(output())
                .isEqualTo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    @Test
    @DisplayName("자동차 입력 안내 메시지가 정상적으로 출력되는지 확인한다.")
    void printInputRacingRoundsMessageTest() {
        printInputRacingRoundsMessage();

        assertThat(output())
                .isEqualTo("시도할 회수는 몇 회 인가요?");
    }

}