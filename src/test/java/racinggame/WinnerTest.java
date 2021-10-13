package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private Car carA;
    private Car carB;
    private Car carC;
    private Car carD;
    private Car carE;

    @BeforeEach
    void setup() {
        carA = new Car("carA");
        carA.move(0);
        carA.move(0);
        carB = new Car("carB");
        carB.move(0);
        carB.move(0);
        carC = new Car("carC");
        carC.move(1);
        carC.move(7);
        carD = new Car("carD");
        carD.move(7);
        carD.move(7);
        carE = new Car("carE");
        carE.move(9);
        carE.move(7);
    }

    @Test
    void max_position_0() {
        Winner winner = new Winner(Arrays.asList(carA, carB));
        assertThat(winner.calMaxPosition()).isEqualTo(0);
    }

    @Test
    void max_position_1() {
        Winner winner = new Winner(Arrays.asList(carA, carB, carC));
        assertThat(winner.calMaxPosition()).isEqualTo(1);
    }

    @Test
    void max_position_2() {
        Winner winner = new Winner(Arrays.asList(carA, carB, carC, carD, carE));
        assertThat(winner.calMaxPosition()).isEqualTo(2);
    }

    @Test
    void no_winner() {
        Winner winner = new Winner(Arrays.asList(carA, carB));
        assertThat(winner.findWinners()).isEmpty();
    }

    @Test
    void one_winner() {
        Winner winner = new Winner(Arrays.asList(carA, carB, carC));
        assertThat(winner.findWinners()).isEqualTo(Collections.singletonList("carC"));
    }

    @Test
    void two_winner() {
        Winner winner = new Winner(Arrays.asList(carA, carB, carC, carD, carE));
        assertThat(winner.findWinners()).isEqualTo(Arrays.asList("carD", "carE"));
    }
}
