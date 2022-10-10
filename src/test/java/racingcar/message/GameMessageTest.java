package racingcar.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("common - message ( GameMessageTest )")
class GameMessageTest {
    @Test
    @DisplayName("자동차 이름 질의문 메시지")
    void car_names_inquire_message_test() {
        // Given
        String testingString = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.NAMES_REQUIRE_MESSAGE);
    }

    @Test
    @DisplayName("게임 라운드수 질의문 메시지")
    void game_rounds_inquire_message_test() {
        // Given
        String testingString = "시도할 회수는 몇회인가요?";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.ROUNDS_REQUIRE_MESSAGE);
    }

    @Test
    @DisplayName("라운드 실행전 안내 메시지")
    void info_message_befroe_round_start_test() {
        // Given
        String testingString = "실행 결과(실행 결과는 누적 전진수를 의미합니다. - 문자는 한칸을 전진했다는걸 의미합니다.)";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.INFO_MESSAGE_BEFORE_RODUN_START);
    }
}