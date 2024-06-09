package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    private RacingGame game;

    @BeforeEach
    void setUp() {
        String[] carNames = {"car1", "car2", "car3"};
        game = new RacingGame(carNames, 5);
    }

    @Test
    @DisplayName("게임이 정상적으로 생성된다.")
    void racingGameShouldInitializeCorrectly() {
        assertThat(game).isNotNull();
    }
    

    @Test
    @DisplayName("한 라운드가 정상적으로 진행된다.")
    void racingGameShouldPlayOneRound() {
        game.playRound();
        List<String> carStatuses = game.getCarStatuses();

        assertThat(carStatuses).hasSize(3);
        carStatuses.forEach(status -> assertThat(status).matches("car[1-3] : -*"));
    }

    @Test
    @DisplayName("우승자를 정상적으로 식별한다.")
    void racingGameShouldIdentifyWinnersCorrectly() {
        game.play();

        String winners = game.getWinners();
        assertThat(winners).isNotEmpty();
    }

    @Test
    @DisplayName("가장 멀리 간 자동차의 위치를 반환한다.")
    void racingGameShouldReturnMaxPosition() {
        game.play();

        int maxPosition = game.getMaxPosition();
        assertThat(maxPosition).isGreaterThanOrEqualTo(0);
    }
}
