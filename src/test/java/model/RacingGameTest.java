package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {

    @Test
    public void 경주_우승자_테스트() {
        RacingGame game = new RacingGame(List.of("pobi", "woni", "jun"), 5);
        game.getCars().get(0).move(true);
        game.getCars().get(1).move(false);
        game.getCars().get(2).move(true);

        List<String> winners = game.getWinners();
        assertThat(winners).containsExactly("pobi", "jun");
    }
}
