package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;
import racingcar.domain.game.GameRoundResult;
import racingcar.domain.game.GameRoundResults;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRoundResultsTest {

    @Test
    @DisplayName("게임 라운드 결과 리스트가 비어있는 일급컬렉션을 생성한다.")
    void test_createEmptyGameRoundResults() {
        //when
        GameRoundResults gameRoundResults = GameRoundResults.createEmptyGameRoundResults();

        //then
        assertThat(gameRoundResults.getGameRoundResults()).hasSize(0);
    }

    @Test
    @DisplayName("한 게임 라운드 결과를 추가한다.")
    void test_addGameRoundResult() {
        //given
        GameRoundResults gameRoundResults = GameRoundResults.createEmptyGameRoundResults();

        Map<CarName, CarPosition> playedOneRoundResultMap = new HashMap<>();
        playedOneRoundResultMap.put(CarName.createCarName("car1"), CarPosition.createCarPosition(1));
        playedOneRoundResultMap.put(CarName.createCarName("car2"), CarPosition.createCarPosition(0));

        //when
        gameRoundResults.addGameRoundResult(GameRoundResult.createGameRoundResult(playedOneRoundResultMap));

        //then
        assertThat(gameRoundResults.getGameRoundResults()).hasSize(1);
    }

    @Test
    @DisplayName("반환된 게임 라운드 결과들을 수정하고자 하면 UnsupportedOperationException을 반환한다.")
    void test_modifyGameWinners() {
        //given
        GameRoundResults gameRoundResults = GameRoundResults.createEmptyGameRoundResults();

        Map<CarName, CarPosition> playedOneRoundResultMap = new HashMap<>();
        playedOneRoundResultMap.put(CarName.createCarName("car1"), CarPosition.createCarPosition(1));
        playedOneRoundResultMap.put(CarName.createCarName("car2"), CarPosition.createCarPosition(0));

        gameRoundResults.addGameRoundResult(GameRoundResult.createGameRoundResult(playedOneRoundResultMap));

        //when then
        assertThatThrownBy(
                () -> gameRoundResults.getGameRoundResults().get(0).getGameRoundResultMap()
                        .replace(CarName.createCarName("car1"), CarPosition.createCarPosition(3)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
