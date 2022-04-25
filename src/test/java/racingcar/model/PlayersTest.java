package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.primitive.Name;
import racingcar.strategy.MovementStrategy;
import racingcar.strategy.RacingCarGameStrategy;

class PlayersTest {


    @ParameterizedTest
    @CsvSource(value = {"java, jigi, john, jane"}, delimiter = ';')
    @DisplayName("생성자에 파라미터 넘긴 후, 정상적으로 작동하는 지 확인")
    void playersInitAndCheckData(String names) {
        System.out.println(names);
        Players players = new Players(names);
        List<Name> playerList = players.firstPlayerNames();

        for (Name name : playerList) {
            assertThat(names).contains(name.getName());
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"java, jigi, john, jane; 4"}, delimiter = ';')
    @DisplayName("생성자에 파라미터 넘긴 후, 전체 성적 확인하는 코드 작성")
    void playersInitAndShowAllDataForScoreBoard(String names, int expected) {
        Players players = new Players(names);
        MovementStrategy movementStrategy = new RacingCarGameStrategy();
        for (int loop = 0; loop < 100; loop++) {
            players.moveWithStrategy(movementStrategy);
        }
        String allResult = players.currentScores();
        assertThat(allResult.split(";").length).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"java, jigi, john; 10; 10"}, delimiter = ';')
    @DisplayName("항상 움직일 때, 전진거리가 입력된 게임 횟수만큼 증가했는지 확인")
    void playersInitAndMovementWithAllTrueStreategy(String names, int loopCount, int expected) {
        Players players = new Players(names);
        for (int loop = 0; loop < loopCount; loop++) {
            players.moveWithStrategy(() -> true);
        }
        String allResult = players.currentScores();
        String[] values = allResult.split(";");
        for (String eachOne : values) {
            Integer value = Integer.valueOf(eachOne.split(":")[1]);
            assertThat(value).isEqualTo(expected);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"java, jigi, john; 10; 0"}, delimiter = ';')
    @DisplayName("항상 멈춰있을 때, 전진거리가 입력된 게임 횟수와 무관하게 0인지 확인")
    void playersInitAndMovementWithAllFalseStreategy(String names, int loopCount, int expected) {
        Players players = new Players(names);
        for (int loop = 0; loop < loopCount; loop++) {
            players.moveWithStrategy(() -> false);
        }
        String allResult = players.currentScores();
        String[] values = allResult.split(";");
        for (String eachOne : values) {
            Integer value = Integer.valueOf(eachOne.split(":")[1]);
            assertThat(value).isEqualTo(expected);
        }
    }
}