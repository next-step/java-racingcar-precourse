package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    @DisplayName("우승자를 판단하고, 우승자 목록을 반환한다.")
    @Test
    void judgeWinners() throws Exception {
        //given
        String[] carNames = {"kia", "good", "test", "hyu"};
        RacingCarGame racingCarGame = new RacingCarGame(carNames);

        //when
        List<Car> winners = racingCarGame.judgeWinners();

        //then  -> 전진 없이 모두가 같은 위치이므로 모두가 우승자
        assertThat(winners.size()).isEqualTo(carNames.length);
    }

}
