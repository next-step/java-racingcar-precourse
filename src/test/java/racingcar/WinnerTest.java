package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.GameResult;
import racingcar.domain.GameStatus;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @DisplayName("가장 많이 움직인 거리 구하기")
    @Test
    void maxPosition() {
        Game game = new Game("pobi,woni,woo");
        GameResult gameResult = game.gameResult();
        gameResult.addStatus(new GameStatus(Arrays.asList(5,0,1)));
        assertThat(gameResult.getGameResult().get(0).getMaxPosition()).isEqualTo(5);
    }

    @DisplayName("우승자 구하기")
    @Test
    void getWinner() {
        Game game = new Game("pobi,woni,woo");
        GameResult gameResult = game.gameResult();
        game.playerList().carList().get(0).moveOrStop(()->5);
        game.playerList().carList().get(0).moveOrStop(()->5);
        game.playerList().carList().get(0).moveOrStop(()->5);
        game.playerList().carList().get(0).moveOrStop(()->5);
        game.playerList().carList().get(0).moveOrStop(()->5);
        game.playerList().carList().get(1).moveOrStop(()->0);
        game.playerList().carList().get(2).moveOrStop(()->5);
        gameResult.addStatus(new GameStatus(Arrays.asList(5,0,1)));

        assertThat(game.getWinner()).isEqualTo("pobi");
    }

    @DisplayName("중복 우승자 구하기")
    @Test
    void getDoubleWinner() {
        Game game = new Game("pobi,woni,woo");
        GameResult gameResult = game.gameResult();
        game.playerList().carList().get(0).moveOrStop(()->5);
        game.playerList().carList().get(0).moveOrStop(()->5);
        game.playerList().carList().get(1).moveOrStop(()->5);
        game.playerList().carList().get(1).moveOrStop(()->5);
        game.playerList().carList().get(2).moveOrStop(()->1);
        gameResult.addStatus(new GameStatus(Arrays.asList(2,2,0)));

        assertThat(game.getWinner()).isEqualTo("pobi,woni");
    }
}
