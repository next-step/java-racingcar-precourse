package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.InputCarName;

class RacingGameTest {
    private RacingGame game;
    private Cars cars;
    private Car pobi;
    private Car crong;
    private Car honux;

    @BeforeEach
    void setUp() {
        InputCarName inputCarName = new InputCarName("pobi,crong,honux");
        cars = inputCarName.create();
        game = new RacingGame(new TryCount("3"), cars);

        List<Car> players = cars.getCars();
        pobi = players.get(0);
        crong = players.get(1);
        honux = players.get(2);
    }

    @Test
    @DisplayName("임의의 값이 주어졌을 때 자동차 전진 횟수")
    void playersMovingCount() {
        game.isMovingForward(pobi, new Racing(9));
        game.isMovingForward(pobi, new Racing(3));
        game.isMovingForward(pobi, new Racing(1));
        game.isMovingForward(crong, new Racing(1));
        game.isMovingForward(crong, new Racing(7));
        game.isMovingForward(crong, new Racing(6));
        game.isMovingForward(honux, new Racing(0));
        game.isMovingForward(honux, new Racing(9));
        game.isMovingForward(honux, new Racing(3));

        assertThat(pobi.getMovingCount()).isEqualTo(1);
        assertThat(crong.getMovingCount()).isEqualTo(2);
        assertThat(honux.getMovingCount()).isEqualTo(1);
    }
}