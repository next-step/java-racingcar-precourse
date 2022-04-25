package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.BaseConstants.PRINT_MSG_PLAY_RESULT;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.StandardOutputAssertionTest;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingPlayersResultTest extends StandardOutputAssertionTest {

    /** example
      1] 실행 결과
      2] melon: -
      3] apple: -
      4]
      5] melon: -
      6] apple: --
      7]
      8] 최종 우승자: apple
      */
    @Test
    @DisplayName("레이실 실행 결과 출력 테스트")
    void 레이싱_실행결과_출력_RacingPlayersResult_test() {
        final RacingPlayers racingPlayers = new RacingPlayers("melon,apple");
        final RacingMovingRound racingMovingNumber = new RacingMovingRound("2");

        // racingMovingNumber 횟수 별로 실행하고 그 결과를 출력한다.
        racingPlayers.play(racingMovingNumber);
        assertThat(output()).contains(PRINT_MSG_PLAY_RESULT, "melon : ", "apple : ", "최종 우승자: ");

        assertEquals(8, Arrays.asList(output().split("\n")).size());
    }
}
