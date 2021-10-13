package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void before() {
        game = new Game();
    }

    @Test
    void 자동차_이름_검증_5글자_이하() {
        boolean validatedCarName = game.isValidatedCarName(new String[]{"KIA"});
        assertTrue(validatedCarName);
    }

    @Test
    void 자동차_이름_검증_6글자_이상() {
        boolean validatedCarName = game.isValidatedCarName(new String[]{"Lamborghini"});
        assertFalse(validatedCarName);
    }

    @Test
    void 우승자_찾기() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("KIA", 5);
        Car car2 = new Car("FORD", 3);
        cars.add(car1);
        cars.add(car2);

        List<Car> winners = game.findWinners(cars);
        List<String> winnerList = game.getWinnerList(winners);
        String[] winner = winnerList.toArray(new String[winnerList.size()]);
        String[] result = new String[]{"KIA"};

        assertArrayEquals(winner, result);
    }

}