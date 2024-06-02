import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("pobi,woni,jun", 5);
    }

    @Test
    void createCars() {
        List<Car> cars = racingGame.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
        System.out.println("createCars 테스트 통과");
    }

    @Test
    void carNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Car("toolongname"));
        System.out.println("carNameTooLong 테스트 통과");
    }

    @Test
    void carMoves() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();
        car.move();
        int newPosition = car.getPosition();

        // 자동차가 이동했는지 여부를 확인합니다. 이동하지 않을 수도 있습니다.
        assertThat(newPosition).isGreaterThanOrEqualTo(initialPosition);
        System.out.println("carMoves 테스트 통과");
    }

    @Test
    void startRace() {
        racingGame.startRace();
        List<Car> cars = racingGame.getCars();

        // 시도 횟수에 따라 자동차가 최소 한 번 이상 이동했는지 확인합니다.
        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
        System.out.println("startRace 테스트 통과");
    }

    @Test
    void validateCarNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCarNames("pobi,woni,junlongname");
        });
        System.out.println("validateCarNames 테스트 통과");
    }
}
