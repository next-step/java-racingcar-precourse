package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @Test
    void generateWinnersNameMessage() {
        Winner winner = new Winner(Arrays.asList(new Car("hello"), new Car("java"), new Car("world")));
        assertThat(winner.generateWinnersNameMessage()).isEqualTo("hello, java, world");
    }
}