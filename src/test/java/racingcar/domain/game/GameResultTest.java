package racingcar.domain.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.CarPosition;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.GameRoundResult;
import racingcar.domain.game.GameRoundResults;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.Fixtures.car1;
import static racingcar.domain.Fixtures.car2;

public class GameResultTest {

    private GameRoundResults gameRoundResults;
    private CarNames winnerCarNames;

    @BeforeEach
    private void playGame() {
        Car car1 = car1();
        Car car2 = car2();

        gameRoundResults = GameRoundResults.createEmptyGameRoundResults();

        Map<CarName, CarPosition> firstRoundResultMap = new HashMap<>();
        firstRoundResultMap.put(car1.getName(), CarPosition.createCarPosition(1));
        firstRoundResultMap.put(car2.getName(), CarPosition.createCarPosition(0));
        gameRoundResults.addGameRoundResult(GameRoundResult.createGameRoundResult(firstRoundResultMap));

        Map<CarName, CarPosition> secondRoundResultMap = new HashMap<>();
        secondRoundResultMap.put(car1.getName(), CarPosition.createCarPosition(2));
        secondRoundResultMap.put(car2.getName(), CarPosition.createCarPosition(0));
        gameRoundResults.addGameRoundResult(GameRoundResult.createGameRoundResult(secondRoundResultMap));

        winnerCarNames = CarNames.createCarNamesWithCarName(Collections.singletonList(car1.getName()));
    }

    @Test
    @DisplayName("게임의 총 결과를 생성한다.")
    void test_createGameResult() {
        Assertions.assertDoesNotThrow(() -> GameResult.createGameResult(gameRoundResults, winnerCarNames));
    }

    @Test
    @DisplayName("반환된 게임 라운드 결과들을 수정하고자 하면 UnsupportedOperationException을 반환한다.")
    void test_modifyGameRoundResults() {
        //given
        GameResult gameResult = GameResult.createGameResult(gameRoundResults, winnerCarNames);
        List<GameRoundResult> gameRoundResultList = gameResult.getGameRoundResults().getGameRoundResults();

        //when then
        assertThatThrownBy(
                () -> gameRoundResultList.get(0).getGameRoundResultMap()
                        .put(CarName.createCarName("car3"), CarPosition.createCarPosition(1)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("반환된 게임 우승자 결과들을 수정하고자 하면 UnsupportedOperationException을 반환한다.")
    void test_modifyGameWinners() {
        //given
        GameResult gameResult = GameResult.createGameResult(gameRoundResults, winnerCarNames);
        List<CarName> gameWinners = gameResult.getWinnerCars().getCarNames();

        //when then
        assertThatThrownBy(() -> gameWinners.add(CarName.createCarName("car3")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
