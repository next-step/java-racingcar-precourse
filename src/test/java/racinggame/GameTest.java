package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest extends NSTest {
    Game game ;
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        setUp();
        game = new Game();
        cars.add(new Car("test1", 2));
        cars.add(new Car("test2", 4));
        cars.add(new Car("test3", 1));

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void printCarsPlace() {
        String result = game.printCarsPlace(cars);
        assertEquals("test1 : --\ntest2 : ----\ntest3 : -\n", result);
    }

    @Test
    void printWinnerResult() {
        String result = game.printWinnerResult(cars);
        assertEquals("test2", result);
    }

    @Test
    void carsToString() {
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
