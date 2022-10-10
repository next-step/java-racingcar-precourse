package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameRoundResultTest {

    private CarName car1Name = CarName.createCarName("car1");
    private CarName car2Name = CarName.createCarName("car2");
    private CarPosition car1Position = CarPosition.createCarPosition(3);
    private CarPosition car2Position = CarPosition.createCarPosition(4);
    private Map<CarName, CarPosition> playedOneRoundResultMap;

    @BeforeEach
    private void setPlayOneRound() {
        playedOneRoundResultMap = new HashMap<>();
        playedOneRoundResultMap.put(car1Name, car1Position);
        playedOneRoundResultMap.put(car2Name, car2Position);
    }

    @Test
    @DisplayName("한 게임 라운드를 진행한 결과 일급컬렉션을 생성한다.")
    void test_getGameRoundResult() {

        //when
        assertDoesNotThrow(() -> GameRoundResult.createGameRoundResult(playedOneRoundResultMap));
    }

    @Test
    @DisplayName("한 게임 라운드를 진행한 자동차의 이름과 그 자동차의 위치를 반환한다.")
    void test_getCarNameAndPosition() {
        //given
        GameRoundResult gameRoundResult = GameRoundResult.createGameRoundResult(playedOneRoundResultMap);

        //when
        Map<CarName, CarPosition> gameRoundResultMap = gameRoundResult.getGameRoundResultMap();

        //then
        assertAll(
                () -> assertThat(gameRoundResultMap.get(car1Name)).isEqualTo(car1Position),
                () -> assertThat(gameRoundResultMap.get(car2Name)).isEqualTo(car2Position)
        );
    }

    @Test
    @DisplayName("반환받은 게임 결과 정보들은 수정하려고 하면 UnsupportedOperationException을 반환한다.")
    void test_cannotModify() {
        //given
        GameRoundResult gameRoundResult = GameRoundResult.createGameRoundResult(playedOneRoundResultMap);

        //when
        Map<CarName, CarPosition> gameRoundResultMap = gameRoundResult.getGameRoundResultMap();

        //then
        assertThatThrownBy(() -> gameRoundResultMap.replace(car1Name, CarPosition.createCarPosition(10)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
