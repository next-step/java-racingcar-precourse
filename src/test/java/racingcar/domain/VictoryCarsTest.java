package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.InputCarName;

class VictoryCarsTest {
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
    @DisplayName("가장 많이 전진한 횟수를 찾는다.")
    void findMaxMovingForward() {
        game.isMovingForward(pobi, new Racing(9));
        game.isMovingForward(pobi, new Racing(6));
        game.isMovingForward(pobi, new Racing(5));
        game.isMovingForward(crong, new Racing(1));
        game.isMovingForward(crong, new Racing(7));
        game.isMovingForward(crong, new Racing(6));
        game.isMovingForward(honux, new Racing(0));
        game.isMovingForward(honux, new Racing(9));
        game.isMovingForward(honux, new Racing(6));

        VictoryCars victoryCars = new VictoryCars(cars);
        int maxMovingForward = victoryCars.findMaxMovingForward(cars);
        assertThat(maxMovingForward).isEqualTo(3);
    }

    @Test
    @DisplayName("가장 많이 전진한 횟수만큼 이동한 자동차를 찾는다 - 단독우승자")
    void soleWinner_VictoryCars() {
        game.isMovingForward(pobi, new Racing(9));
        game.isMovingForward(pobi, new Racing(6));
        game.isMovingForward(pobi, new Racing(5));
        game.isMovingForward(crong, new Racing(1));
        game.isMovingForward(crong, new Racing(7));
        game.isMovingForward(crong, new Racing(6));
        game.isMovingForward(honux, new Racing(0));
        game.isMovingForward(honux, new Racing(9));
        game.isMovingForward(honux, new Racing(6));

        VictoryCars victoryCars = new VictoryCars(cars);
        assertThat(victoryCars.getVictoryCars()).containsExactly(pobi);
    }

    @Test
    @DisplayName("가장 많이 전진한 횟수만큼 이동한 자동차를 찾는다 - 공동우승자")
    void winners_VictoryCars() {
        game.isMovingForward(pobi, new Racing(9));
        game.isMovingForward(pobi, new Racing(6));
        game.isMovingForward(pobi, new Racing(5));
        game.isMovingForward(crong, new Racing(1));
        game.isMovingForward(crong, new Racing(7));
        game.isMovingForward(crong, new Racing(6));
        game.isMovingForward(honux, new Racing(7));
        game.isMovingForward(honux, new Racing(9));
        game.isMovingForward(honux, new Racing(6));

        VictoryCars victoryCars = new VictoryCars(cars);
        assertThat(victoryCars.getVictoryCars()).containsExactly(pobi, honux);
    }
}