package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarStatus;
import racingcar.domain.Cars;
import racingcar.service.RacingCarService;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarPlayTest extends NsTest {

    private static RacingCarService racingCarService = new RacingCarService();

    @Test
    void 랜덤_이동_테스트() {
        Car car = new Car("poby");
        assertThat(car.run(4).equals(CarStatus.GO)).isTrue();
        assertThat(car.run(3).equals(CarStatus.STOP)).isTrue();
    }

    @Test
    void 자동차_경기_상태_오류_체크() {
        Cars cars = new Cars(Arrays.asList(new Car("poby")));
        assertThat(cars.isStateComplete(CarStatus.GO)).isTrue();
        assertThat(cars.isStateComplete(CarStatus.STOP)).isTrue();
    }

    @Test
    void 랜덤_숫자_범위_체크() {
        Cars cars = new Cars(Arrays.asList(new Car("poby")));
        assertThat(cars.getRandomNum()).isBetween(0, 9);
    }

    @Test
    void 자동차_한개만_입력할_경우_체크() {
        assertSimpleTest(
                () -> {
                    runException("pobi");
                    assertThat(output()).contains("자동차 2대 이상 입력해주세요");
                }
        );
    }

    @Test
    void 자동차_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(Arrays.asList(new Car("poby")));
                    CarStatus play = cars.play();
                    assertThat(play.equals(CarStatus.GO));
                },
                4, 3
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
