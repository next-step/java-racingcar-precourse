package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {
    private Game game;
    private Cars cars;

    @BeforeEach
    void setUp() {
        String[] carNames = new String[]{"국산차", "외제차"};
        Progress progress = new Progress(3);

        this.cars = new Cars(carNames);
        this.game = new Game(cars, progress);
    }

    @Test
    @DisplayName("자동차와 시도할 횟수를 생성자를 통해 초기화")
    void 게임_생성() {
        assertThat(game.carCount()).isEqualTo(2);
        assertThat(game.progressCount()).isEqualTo(3);
    }

    @Test
    void 게임_시작시_게임상태_시작() {
        game.play();

        assertThat(game.getStatus()).isEqualTo(GameStatus.PLAY);
    }

    @Test
    void 게임_종료시_게임상태_종료() {
        game.end();

        assertThat(game.getStatus()).isEqualTo(GameStatus.END);
    }

    @Test
    void 게임_진행_마지막_결과_확인() {
        GameResults gameResults = game.play();

        assertThat(gameResults.lastGameResult()).usingRecursiveComparison().isEqualTo(new GameResult(cars));
    }
}
