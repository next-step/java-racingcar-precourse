package racingcar.damain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Cars cars;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void init() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("happy"));
        carList.add(new Car("good"));
        carList.add(new Car("star"));
        cars = new Cars(carList);
    }

    @Test
    void tryOutMove() {
        assertRandomNumberInRangeTest(
            () -> {
                cars.tryOutMove();
                cars.tryOutMove();
                cars.tryOutMove();

                assertThat(cars.getCars().get(0).getPosition()).isEqualTo(3);
                assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
                assertThat(cars.getCars().get(2).getPosition()).isEqualTo(2);
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void getWinners() {
        assertRandomNumberInRangeTest(
            () -> {
                cars.tryOutMove();
                cars.tryOutMove();
                cars.tryOutMove();

                assertThat(cars.getWinners(3).get(0).getCarName()).isEqualTo("happy");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP, STOP
        );
    }
}