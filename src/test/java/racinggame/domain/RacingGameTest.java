package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 생성() {
        assertEquals(new RacingGame(new Cars("kdg")), new RacingGame(new Cars("kdg")));
    }

    @Test
    void 우승자_찾기() {
        RacingGame game = new RacingGame(new Cars("abc,def"), true);
        assertEquals(new Winners(Arrays.asList(new Car("abc"), new Car("def"))), game.winners());
    }

    @Test
    void 게임이_종료되지_않았으면_우승를_찾을_수_없음() {
        RacingGame game = new RacingGame(new Cars("abc,def"));
        assertThrows(IllegalStateException.class, game::winners);
    }

    @Test
    void 다음_게임() {
        assertDoesNotThrow(() -> {
            RacingGame game = new RacingGame(new Cars("abc,def"));
            game.next(() -> true, false);
            assertEquals(game.isFinish(), false);
        });
    }

    @Test
    void 게임이_종료된_이후에는_레이싱_불가능() {
        assertThrows(IllegalStateException.class, () -> {
            RacingGame game = new RacingGame(new Cars("abc,def"), true);
            game.next(() -> true, false);
        });
    }

}