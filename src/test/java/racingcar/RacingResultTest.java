package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.PlayResult;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest extends NsTest {

    @Test
    void 자동차_진행_출력() {
        assertSimpleTest(
                () -> {
                    Car car = new Car("poby");
                    PlayResult.getProcessPrint(car);
                    assertThat(output()).contains(car.getName() + " :");
                }
        );
    }

    @Test
    void 우승자_출력() {
        assertSimpleTest(
                () -> {
                    Car car = new Car("poby");
                    PlayResult.getResultPrint(Arrays.asList(car.getName()));
                    assertThat(output()).contains("최종 우승자: " + car.getName());
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}