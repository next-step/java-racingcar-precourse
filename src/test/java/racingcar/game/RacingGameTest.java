package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.utils.TestCarsUtils.testInputCarNames;
import static racingcar.utils.TestCarsUtils.testInputRoundCount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임 생성 성공 테스트")
    void initOf() {
        // given

        // when & then
        assertDoesNotThrow(() -> RacingGame.initOf(testInputCarNames(), testInputRoundCount()));

    }

    @Test
    @DisplayName("레이싱 게임 시작 성공 테스트")
    void gameStart() {
        // given
        final RacingGame racingGame = RacingGame.initOf(testInputCarNames(), testInputRoundCount());

        // when
        racingGame.gameStart();

        // then
        assertThat(racingGame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("레이싱 우승자 조회 성공 테스트")
    void winnersToCars() {
        // given
        final RacingGame racingGame = RacingGame.initOf(testInputCarNames(), testInputRoundCount());
        racingGame.gameStart();

        // when & then
        assertThat(racingGame.winnersToCars().countCars()).isGreaterThan(0);
    }
}