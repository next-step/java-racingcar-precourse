package racingcar;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.GameManager;

public class GameManagerTest {

    @Test
    public void make_racing_cars_test() {
        String[] racingCars = {"aaaa", "bbbb", "cccc", "dddd"};
        GameManager gameManager = new GameManager(racingCars);
        assertThat(gameManager.getCarList().size()).isEqualTo(4);
    }

    @Test
    public void getRacingWinnersTest() {
        String[] racingCars = {"aaaa", "bbbb", "cccc", "dddd"};
        GameManager gameManager = new GameManager(racingCars);
        List<Car> racingWinners = gameManager.getRacingWinners();
        assertThat(racingWinners).contains(new Car("aaaa"), new Car("bbbb"), new Car("cccc"), new Car("dddd"));
    }
}
