package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Winner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {

    private Cars users;
    private Winner winner;
    private Car dony;
    private Car chuny;
    private Car junny;

    @BeforeEach
    void setUp() {
        dony = new Car("dony");
        chuny = new Car("chuny");
        junny = new Car("junny");
        users = new Cars(Arrays.asList(dony, chuny, junny));
        winner = new Winner(users);
    }

    @Test
    void 우승자_1명_확인() {
        dony.move(4);
        chuny.move(3);
        junny.move(2);
        dony.move(6);
        chuny.move(7);
        junny.move(8);
        assertEquals(dony.getPosition(), 2);
        assertEquals(chuny.getPosition(), 1);
        assertEquals(junny.getPosition(), 1);
        assertEquals(winner.getWinner(), "dony");
    }

    @Test
    void 우승자_2명_확인() {
        dony.move(4);
        chuny.move(5);
        junny.move(2);
        dony.move(7);
        chuny.move(9);
        junny.move(4);
        assertEquals(dony.getPosition(), 2);
        assertEquals(chuny.getPosition(), 2);
        assertEquals(junny.getPosition(), 1);
        assertEquals(winner.getWinner(), "dony,chuny");
    }
}
