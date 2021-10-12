package racinggame.game.model.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultMessageTest {

    @DisplayName("회차 결과 메세지 비교 테스트")
    @Test
    void test() {
        String carName = "C01";
        int forwardMovementCount = 3;
        RaceResultMessage resultMessage = new RaceResultMessage(carName, forwardMovementCount);

        String result = carName + " : ---";
        assertThat(result.equals(resultMessage.getMessage())).isTrue();
    }
}