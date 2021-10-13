package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName(value = "쉼표(,)기준으로 자동차들을 생성")
    public void 자동차이름을입력한다() {
        RacingGame racingGame = new RacingGame(RacingGame.initCars("pobi,crong,honux"), 0);
        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName(value = "이름을 빈값 입력시 오류 발생")
    public void 자동차빈값오류발생() {
        assertThatThrownBy(() -> {
            RacingGame racingGame = new RacingGame(RacingGame.initCars(""), 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value = "주어진 횟수동안 Racing을 반복했는가")
    public void 횟수동안레이싱했는가() {
        int tryNo = 3;
        int raceCount = 0;
        RacingGame racingGame = new RacingGame(RacingGame.initCars("pobi"), tryNo);
        while(racingGame.racing()) {
            raceCount++;
            racingGame.race();
        }
        assertThat(raceCount).isEqualTo(tryNo);
    }
}