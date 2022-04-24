package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.GameRule;
import racingcar.model.TryCount;

public class CarTest {

    private static final String INPUT_TRY_COUNT = "3";
    private static final String CAR_NAME = "TeCar";
    private static final String COMPARABLE_CAR = "CCar";
    private GameRule gameRule;
    private Car car;

    @BeforeEach
    void setUP() {
        gameRule = new GameRule(new TryCount(INPUT_TRY_COUNT));
        car = new Car(CAR_NAME);
        car.moveCar(gameRule);
    }

    @Test
    void 자동차_이동_회수_정상() {
        assertEquals(car.getPosition().size(), Integer.valueOf(INPUT_TRY_COUNT));
    }

    @Test
    void 자동차_승자() {
        Car comparableCar = new Car(COMPARABLE_CAR);
        assertEquals(car.getWinnerCar(null), car);
        assertEquals(car.getWinnerCar(comparableCar), car);
    }

    @Test
    void 공동_우승자() {
        assertTrue(car.isJointWinner(car));
    }
}
