package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomUtils;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    Cars cars;

    @BeforeEach
    void initCars() {
        List<String> names = Arrays.asList("yb", "pobi", "java");

        cars = new Cars(names);
    }

    @Test
    @DisplayName("참여 자동차 수 테스트")
    void size() {
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void winners() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car ybCar = new Car("yb");
                    Car pobiCar = new Car("pobi");

                    ybCar.stopAndGo(MOVING_FORWARD);
                    pobiCar.stopAndGo(MOVING_FORWARD);

                    runMain();
                    assertThat(cars.winners(1))
                            .filteredOn(car -> {
                                        System.out.println(car.equals(ybCar));
                                        return car.equals(ybCar) || car.equals(pobiCar);
                                    }
                                )
                            .hasSize(2);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        cars.move(RandomUtils.randomNumbers(cars.size()));
    }
}