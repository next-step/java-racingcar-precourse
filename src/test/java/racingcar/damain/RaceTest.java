package racingcar.damain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {
    private Race race;
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
        race = new Race(cars, new TryoutCount("5"), new WinnerStatus());
    }

    @Test
    void tryoutMove() {
        assertRandomNumberInRangeTest(
            () -> {
                race.tryoutMove();

                assertThat(cars.getCars().get(0).getPosition()).isEqualTo(5);
                assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
                assertThat(cars.getCars().get(2).getPosition()).isEqualTo(3);
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void start() {
        assertRandomNumberInRangeTest(
            () -> {
                race.start();

                assertThat(cars.getCars().get(0).getPosition()).isEqualTo(5);
                assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
                assertThat(cars.getCars().get(2).getPosition()).isEqualTo(3);

                assertThat(race.getWinnerStatus().getWinners().get(0).getCarName()).isEqualTo("happy");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}