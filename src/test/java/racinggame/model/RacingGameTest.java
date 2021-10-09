package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.enums.Error;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("RacingGame: 경주 게임을 진행")
public class RacingGameTest {

    @DisplayName("시도 횟수는 0 이 되기 전까지는 True")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void racingGame(int count) {
        RacingGame game = new RacingGame("alice, bob, cook");
        game.setCount(count);

        for (int i = 0; i < count; i++) {
            assertThat(game.canPlay()).isTrue();
            MoveResults results = game.moveOnce(Arrays.asList(0, 0, 0));
            assertThat(results.getOutput()).contains("alice : ");
            assertThat(results.getOutput()).contains("bob : ");
            assertThat(results.getOutput()).contains("cook : ");
        }

        assertThat(game.canPlay()).isFalse();
    }

    @DisplayName("시도 횟수는 0 보다 커야함")
    @Test
    void validateCount() {
        RacingGame game = new RacingGame("alice");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> game.setCount(0))
                .withMessage(Error.INVALID_COUNT.message());
    }

    @DisplayName("게임이 끝나면 최종 우승자를 구할 수 있음")
    @Test
    void testGetWinners() {
        RacingGame game = new RacingGame("alice, bob, cook");
        game.setCount(1);

        MoveResults results = game.moveOnce(Arrays.asList(0, 0, 4));

        assertThat(results.getOutput()).contains("alice : ");
        assertThat(results.getOutput()).contains("bob : ");
        assertThat(results.getOutput()).contains("cook : -");
        assertThat(game.canPlay()).isFalse();

        String winners = game.getWinners();
        assertThat(winners).isEqualTo("cook");
    }

    @DisplayName("최종 우승자가 두명 이상인 경우 쉼표로 구분")
    @Test
    void testGetWinnersMoreThan1() {
        RacingGame game = new RacingGame("alice, bob, cook");
        game.setCount(1);

        MoveResults results = game.moveOnce(Arrays.asList(0, 4, 4));

        assertThat(results.getOutput()).contains("alice : ");
        assertThat(results.getOutput()).contains("bob : -");
        assertThat(results.getOutput()).contains("cook : -");
        assertThat(game.canPlay()).isFalse();

        String winners = game.getWinners();
        assertThat(winners).isEqualTo("bob,cook");
    }
}
