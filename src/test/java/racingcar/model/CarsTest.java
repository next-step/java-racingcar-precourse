package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.factory.CarFactory;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest extends NsTest {

    private static final int MOVING_FORWARD = 4;

    Cars cars;

    @BeforeEach
    void 설정(){
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("krad"));
        carList.add(new Car("kradj"));
        carList.add(new Car("kradk"));

        cars = new Cars(carList);
    }

    @Test
    @DisplayName("자동차_리스트_주행_테스트")
    void 자동차_리스트_주행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.race(new TotalLaps("2"));
                    assertThat(output()).contains("krad : --", "kradj : --", "kradk : --");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차_리스트_우승자_테스트")
    void 자동차_리스트_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.race(new TotalLaps("2"));
                    String winner = cars.winners().winners();
                    assertThat(output()).contains("krad : --", "kradj : --", "kradk : --");
                    assertThat(winner).isEqualTo("krad, kradj, kradk");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {

    }
}
