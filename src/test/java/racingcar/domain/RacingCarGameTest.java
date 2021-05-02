package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 게임 도메인 테스트")
class RacingCarGameTest {

    @DisplayName("자동차 경주 게임 생성")
    @Test
    void 자동차_경주_게임_생성() {
        // when
        RacingCarGame racingCarGame = new RacingCarGame("car1,car2,car3", "10");
        // then
        assertThat(racingCarGame).isNotNull();
    }
}