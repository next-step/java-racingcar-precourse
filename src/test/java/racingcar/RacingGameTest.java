package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;
import racingcar.car.RacingCarName;
import racingcar.car.RacingCars;
import racingcar.game.RacingStageCount;

public class RacingGameTest {

    @Test
    void 이름_빈값_오류_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCars racingCars = new RacingCars();
            racingCars.addRacingCar(new RacingCar(new RacingCarName("")));
        });
    }

    @Test
    void 이름_중복_오류_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCars racingCars = new RacingCars();
            racingCars.addRacingCar(new RacingCar(new RacingCarName("test1")));
            racingCars.addRacingCar(new RacingCar(new RacingCarName("test1")));
        });
    }

    @Test
    void 이름_길이제한_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingCars racingCars = new RacingCars();
            racingCars.addRacingCar(new RacingCar(new RacingCarName("test122")));
        });
    }

    @Test
    void 시도횟수_입력_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingStageCount("dkw");
        });
    }

    @Test
    void 시도횟수로_0이_입력된_경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingStageCount("0");
        });
    }
}
