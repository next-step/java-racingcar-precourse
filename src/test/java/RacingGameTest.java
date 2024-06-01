import org.junit.jupiter.api.Test;
import model.Car;
import model.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void playGame() {
        String[] names = {"tesla", "bmw", "benz"};
        RacingGame game = new RacingGame(names, 5);
        game.play();
        List<Car> cars = game.getCars();

        for (Car car : cars) {
            assertThat(car.getPosition()).isBetween(0, 5);
        }
    }
}
