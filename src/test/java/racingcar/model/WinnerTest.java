package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    Winner winner;

    @BeforeEach
    void setUp() {
        winner = new Winner(Arrays.asList(new Car("hello"), new Car("java"), new Car("world")));
    }

    @Test
    void generateWinnersNameMessage() {
        assertThat(winner.generateWinnersNameMessage()).isEqualTo("hello, java, world");
    }

}