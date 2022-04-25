package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.GameResult;
import racingcar.domain.GameStatus;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @DisplayName("게임 생성 테스트")
    @Test
    void makeGame() {
        Game game = new Game("pobi,woni,woo");

        assertThat(game.playerList().carList().size()).isEqualTo(3);
    }

    @DisplayName("비정상적인 플레이어 이름으로 게임 생성 테스트")
    @Test
    void makeInvalidGame() {
        assertThatThrownBy(() -> {
            new Game("pobi,woni,name_exceed5");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("게임 실행 테스트")
    @Test
    void runGame() {
        Game game = new Game("pobi,woni,woo");
        GameResult gameResult = game.run("5");

        assertThat(gameResult.totalExecuteCount()).isEqualTo(5);
    }

    @DisplayName("게임 실행 수행 테스트")
    @Test
    void runActualGame() {
        Game game = new Game("pobi,woni,woo");
        GameResult gameResult = game.gameResult();
        gameResult.addStatus(new GameStatus(Arrays.asList(1,0,1)));
        gameResult.addStatus(new GameStatus(Arrays.asList(2,1,1)));
        gameResult.addStatus(new GameStatus(Arrays.asList(2,1,1)));
        gameResult.addStatus(new GameStatus(Arrays.asList(3,1,1)));

        List<GameStatus> gameStatusList = gameResult.getGameResult();
        assertThat(gameStatusList.get(0).getGameStatus()).containsExactly(1,0,1);
        assertThat(gameStatusList.get(1).getGameStatus()).containsExactly(2,1,1);
        assertThat(gameStatusList.get(2).getGameStatus()).containsExactly(2,1,1);
        assertThat(gameStatusList.get(3).getGameStatus()).containsExactly(3,1,1);

    }
}
