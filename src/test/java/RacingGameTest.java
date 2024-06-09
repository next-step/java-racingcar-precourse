import model.Car;
import model.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {

    private List<String> carNames;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("Car1", "Car2", "Car3");
        racingGame = new RacingGame(carNames);
    }

    @Test
    @DisplayName("자동차 이름 리스트로 생성자 테스트")
    void testConstructor() {
        List<Car> cars = racingGame.getCars();
        assertEquals(3, cars.size());
        assertEquals("Car1", cars.get(0).getName());
        assertEquals("Car2", cars.get(1).getName());
        assertEquals("Car3", cars.get(2).getName());
    }

    @Test
    @DisplayName("주어진 횟수 동안 자동차 경주 테스트")
    void testRace() {
        racingGame.race(5);
        List<Car> cars = racingGame.getCars();
        for (Car car : cars) {
            assertTrue(car.getPosition() >= 0 && car.getPosition() <= 5);
        }
    }

    @Test
    @DisplayName("우승자 결정 테스트")
    void testGetWinners() {
        racingGame.getCars().get(0).setFixedRandomNumber(5);
        racingGame.getCars().get(1).setFixedRandomNumber(3);
        racingGame.getCars().get(2).setFixedRandomNumber(3);

        racingGame.race(1);

        List<String> winners = racingGame.getWinners();
        assertEquals(1, winners.size());
        assertEquals("Car1", winners.get(0));
    }

    @Test
    @DisplayName("여러 우승자 결정 테스트")
    void testGetMultipleWinners() {
        racingGame.getCars().get(0).setFixedRandomNumber(5);
        racingGame.getCars().get(1).setFixedRandomNumber(5);
        racingGame.getCars().get(2).setFixedRandomNumber(3);

        racingGame.race(1);

        List<String> winners = racingGame.getWinners();
        assertEquals(2, winners.size());
        assertTrue(winners.contains("Car1"));
        assertTrue(winners.contains("Car2"));
    }
}
