package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.IRandomNumberGenerator;
import util.TestRandomNumberGenerator;

class GameServiceTest {
    @Test
    @DisplayName("moveCars test")
    void moveCarsTest() throws Exception {
        // given
        GameService service = new GameService();
        IRandomNumberGenerator moveTestNumberGenerator = new TestRandomNumberGenerator(6);
        IRandomNumberGenerator notMoveTestNumberGenerator = new TestRandomNumberGenerator(2);
        Car move1 = new Car("win1", moveTestNumberGenerator);
        Car move2 = new Car("win2", moveTestNumberGenerator);
        Car not1 = new Car("lose", notMoveTestNumberGenerator);

        List<Car> resultCars = new ArrayList<>();
        resultCars.add(move1);
        resultCars.add(move2);
        resultCars.add(not1);

        // when
        service.moveCars(resultCars);
        service.moveCars(resultCars);

        // then
        assertThat(move1.getPosition()).isEqualTo(2);
        assertThat(move2.getPosition()).isEqualTo(2);
        assertThat(not1.getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("findWinners test")
    void findWinnersTest() throws Exception {
        // given
        GameService service = new GameService();
        IRandomNumberGenerator winTestNumberGenerator = new TestRandomNumberGenerator(6);
        IRandomNumberGenerator loseTestNumberGenerator = new TestRandomNumberGenerator(2);
        Car win1 = new Car("win1", winTestNumberGenerator);
        Car win2 = new Car("win2", winTestNumberGenerator);
        Car lose = new Car("lose", loseTestNumberGenerator);

        // input data
        List<Car> input = new ArrayList<>();
        input.add(win1);
        input.add(lose);
        input.add(win2);
        service.moveCars(input);

        List<Car> expected = new ArrayList<>();
        expected.add(win1);
        expected.add(win2);

        // when
        List<Car> result = service.findWinners(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}