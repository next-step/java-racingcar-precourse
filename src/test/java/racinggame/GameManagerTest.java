package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.GameManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    @Test
    public void make_racing_cars_test() {
        String[] racingCars = {"abc", "edb", "bbb"};
        GameManager gameManager = new GameManager(racingCars);
        assertThat(gameManager.getCarList().size()).isEqualTo(3);
    }


    @Test
    public void getRacingWinnersTest() {
        String[] racingCars = {"abc", "edb", "bbb"};
        GameManager gameManager = new GameManager(racingCars);
        List<Car> racingWinners = gameManager.getRacingWinners();
        assertThat(racingWinners).contains(new Car("abc"), new Car("edb"), new Car("bbb"));
    }
}
