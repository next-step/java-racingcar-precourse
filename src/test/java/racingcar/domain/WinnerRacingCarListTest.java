package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.creator.WinnerRacingCarListCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerRacingCarListTest {

    @DisplayName("winnerRacingCarList에서 이름들을 ,로 구분해서 반환한다.")
    @Test
    void winnerName() {
        // given
        WinnerRacingCarList winnerRacingCarList = WinnerRacingCarListCreator.create();

        // when
        String winnerName = winnerRacingCarList.winnerName();

        // then
        assertThat(winnerName).contains("sun,jo");
    }

}
