package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {
    final private Game game = new Game();
    String carNameInputLengthIsFive = "람보르기니";
    String carNameInputFailByLengthOverFive = "길이가5이상";

    @Test
    @DisplayName(value = "게임 자동차 이름 입력 범위 테스트")
    void inputRacingCarNameTest(){
        assertThat(game.isValidRacingCarNameLength(carNameInputLengthIsFive));
        assertThat(game.isValidRacingCarNameLength(carNameInputFailByLengthOverFive));
    }
}
