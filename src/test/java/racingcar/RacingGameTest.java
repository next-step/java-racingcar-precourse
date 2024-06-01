package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름 초기화 테스트")
    public void testInitializeCars() {
        RacingGame game = new RacingGame("car1,car2,car3", 5);
        List<String> carNames = game.getCarNames();
        //메서드가 입력된 문자열을 올바르게 분리하여 각 자동차 이름을 초기화
        assertThat(carNames).hasSize(3);
        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("시도 횟수 유효성 검사 테스트")
    public void testValidateAttempts() {
        assertThatThrownBy(() -> new RacingGame("car1,car2,car3", 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 회수는 1회 이상이어야 합니다.");
    }

    @Test
    @DisplayName("우승자 추출 테스트")
    public void testGetWinners() {
        RacingGame game = new RacingGame("car1,car2,car3", 5);
        game.start();
        List<String> winners = game.getWinners();
        //적어도 한 명 이상의 우승자 보장
        assertThat(winners).isNotEmpty();
    }
}