package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessageConst;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    RacingCars cars;

    @BeforeEach
    void initialize(){
        String[] carNames = {"car1","car2","car3"};
        cars = new RacingCars(carNames);
    }

    @Test
    @DisplayName("RacingGame 초기화 테스트: 성공")
    void 초기화_테스트_성공(){
        RacingGame racingGame1 = new RacingGame(cars, 1);
        RacingGame racingGame2 = new RacingGame(cars, Integer.MAX_VALUE);
        assertThat(racingGame1).isInstanceOf(RacingGame.class);
        assertThat(racingGame2).isInstanceOf(RacingGame.class);
    }

    @Test
    @DisplayName("RacingGame 초기화 테스트: RepeatCount 0으로 오류 발생")
    void 초기화_테스트_실패_0(){
        assertThatIllegalArgumentException().isThrownBy(
                ()-> new RacingGame(cars, 0)).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_NATURAL_NUMBER_FORMAT,
                                1, Integer.MAX_VALUE)
                );
    }

    @Test
    @DisplayName("RacingGame 초기화 테스트: 실패 - RepeatCount 음수로 오류 발생")
    void 초기화_테스트_실패_음수(){
        assertThatIllegalArgumentException().isThrownBy(
                ()-> new RacingGame(cars, -1)).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_NATURAL_NUMBER_FORMAT,
                                1, Integer.MAX_VALUE)
                );
    }

    @Test
    @DisplayName("게임 종료 테스트")
    void 게임_종료_테스트(){
        RacingGame game = new RacingGame(cars, 3);
        game.playSingleRound();
        game.playSingleRound();
        game.playSingleRound();
        assertThat(game.isGameEnd()).isTrue();
    }

    @Test
    @DisplayName("최종 우승자 테스트: 단독우승")
    void 최종_우승자_테스트_단독우승(){
        assertRandomNumberInRangeTest(
                () -> {
                    RacingGame game = new RacingGame(cars, 2);
                    game.playSingleRound();
                    game.playSingleRound();
                    List<String> winnerNames = game.getWinnerNames();
                    assertThat(winnerNames).hasSize(1);
                    assertThat(winnerNames.get(0)).isEqualTo("car2");
                },
                0,4,4,0,4,0
        );
    }

    @Test
    @DisplayName("최종 우승자 테스트: 공동우승")
    void 최종_우승자_테스트_공동우승(){
        assertRandomNumberInRangeTest(
                () -> {
                    RacingGame game = new RacingGame(cars, 2);
                    game.playSingleRound();
                    game.playSingleRound();
                    List<String> winnerNames = game.getWinnerNames();
                    assertThat(winnerNames).hasSize(2);
                    assertThat(winnerNames.get(0)).isEqualTo("car2");
                    assertThat(winnerNames.get(1)).isEqualTo("car3");
                },
                0,4,4,0,4,4
        );
    }
}
