package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    static final int tryCount = 3;

    @Test
    @DisplayName("게임 횟수 테스트")
    public void gameCountTest() {
        Game game = new Game("test1,test2", String.valueOf(tryCount));
        for (int i = 0; i < tryCount; i++) {
            game.gameStart();
        }
        assertThat(game.gameOver()).isTrue();
    }

    @Test
    @DisplayName("게임 자동차 대수 테스트")
    public void gameCarsCountTest() {
        Game game = new Game("test1,test2", String.valueOf(tryCount));
        List<Car> cars = game.gameStart();
        assertThat(cars.size()).isEqualTo(2);
    }
}
