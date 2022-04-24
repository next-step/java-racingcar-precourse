package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.ui.CarStatus;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


class RacingTest extends NsTest {
    private static Racing racing;
    private static final int MOVE_NUMBER = 4;
    private static final int STOP_NUMBER = 3;

    @BeforeAll
    static void initAll() {
        racing = new Racing();
    }

    @Test
    void 자동차_경주_시작() {
        Cars cars = new Cars();
        cars.add(new Car("one"));
        cars.add(new Car("two"));
        Cars racingResult = racing.start(cars);
        assertThat(output()).contains(cars.get(0).getName() + " : ", "\n" + cars.get(1).getName() + " : ");
    }

    @Test
    void 자동차_전진여부_판단() {
        assertThat(racing.moveOrStop(MOVE_NUMBER)).isEqualTo(CarStatus.MOVE);
        assertThat(racing.moveOrStop(STOP_NUMBER)).isEqualTo(CarStatus.STOP);
    }

    @Test
    void 자동차_위치_문자열_생성() {
        Car car = new Car("moveC");
        car.setStatus(CarStatus.STOP);
        racing.move(car);
        assertThat(car.getLocation()).isEqualTo("");
        car.setStatus(CarStatus.MOVE);
        racing.move(car);
        assertThat(car.getLocation()).isEqualTo("-");
    }

    @Override
    protected void runMain() {

    }
}