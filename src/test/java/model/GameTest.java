package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("자동차 이름을 입력 받아 Game을 생성하고, 전진한다.")
    void advance() {
        // given
        Game game = new Game(List.of("a", "b", "c"));

        // when
        game.advance("a");

        // then
        assertEquals(game.getCarPosition().get("a"), "-");
    }

    @Test
    @DisplayName("우승자를 반환한다.")
    void getWinners() {
        // given
        Game game = new Game(List.of("a", "b", "c"));

        // when
        game.advance("a");
        game.advance("b");
        game.advance("c");
        game.advance("a");
        game.advance("b");

        // then
        assertEquals(game.getWinners(), List.of("a", "b"));
    }

    @Test
    @DisplayName("우승자를 반환한다.")
    void getWinners_no_one_is_advanced() {
        // given
        Game game = new Game(List.of("a", "b", "c"));

        // when
        // then
        assertEquals(game.getWinners(), List.of("a", "b", "c"));
    }
}