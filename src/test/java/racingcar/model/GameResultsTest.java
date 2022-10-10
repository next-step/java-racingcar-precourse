package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameResultsTest {
    private Progress progress;
    private Cars cars;
    private GameResults gameResults;

    @BeforeEach
    void setUp() {
        String[] carNames = new String[]{"test", "test2"};
        this.cars = new Cars(carNames);
        progress = new Progress(3);
        gameResults = new GameResults();
    }

    @Test
    void 첫번째_차수_실행_결과_비교() {
        cars.move();
        GameResult gameResult = new GameResult(cars);
        gameResults.addGameResult(gameResult);

        /* 2번째 차수 실행 */
        for (int i = 1; i < progress.getCount(); i++) {
            cars.move();
            gameResults.addGameResult(new GameResult(cars));
        }

        assertThat(gameResults.getGameResults().get(0)).isEqualTo(gameResult);
    }

    @Test
    void 마지막_차수_실행_결과_비교() {
        for (int i = 0; i < progress.getCount(); i++) {
            cars.move();
            gameResults.addGameResult(new GameResult(cars));
        }

        int size = gameResults.size() - 1;
        assertThat(gameResults.getGameResult(size)).usingRecursiveComparison().isEqualTo(new GameResult(cars));
    }
}
