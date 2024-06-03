package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.RaceGame;

public class RaceGameTest {

    private RaceGame raceGame;

    @BeforeEach
    public void setUp() {
        raceGame = new RaceGame(new String[]{"Car1", "Car2", "Car3"});
    }

    @Test
    public void testDoGame() {
        assertDoesNotThrow(() -> raceGame.doGame(3));
    }

}
