package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinnersTest {

    @Test
    public void 우상자를_한_명이상_가진다() {
        Winner winner1 = new Winner("1");
        Winner winner2 = new Winner("2");
        Winners winners = new Winners(Arrays.asList(winner1, winner2));
        Assertions.assertThat(winners.getWinners().isEmpty()).isFalse();
    }
}
