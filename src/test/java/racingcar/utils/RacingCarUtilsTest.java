package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarUtilsTest {

    @Test
    void 레이싱_참가자_세팅_테스트(){
        List<Car> cars = RacingCarUtils.createRacingCars(new String[]{"dong", "ha", "kim"});
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 레이싱_참가자_글자수_초과_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () ->RacingCarUtils.createRacingCars(new String[]{"dong-ha", "ha", "kim"})
        ).withMessageContaining("[ERROR]");
    }

    @Test
    void 레이싱_참가자_띄어쓰기_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () ->RacingCarUtils.createRacingCars(new String[]{"dong ", "ha", "kim"})
        ).withMessageContaining("[ERROR]");
    }

}
