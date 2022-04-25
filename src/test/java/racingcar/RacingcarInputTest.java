package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarInputTest {

    private static final int NAME_MAX_LENGTH = 5;
    RacingCarService racingCarService = new RacingCarService();

    @Test
    void 자동차_이름_5자_이하_체크() {
        Car car = new Car("poby");
        assertThat(car.getName().length() < NAME_MAX_LENGTH).isTrue();
        car.setName("pobbby");
        assertThat(car.getName().length() < NAME_MAX_LENGTH).isFalse();
    }
    
    @Test
    void 자동차_이름_콤마_포함_체크() {
        Car car = new Car("poby,wow");
        assertThat(racingCarService.checkCarNameComma(car.getName())).isTrue();
        car = new Car("pobbbywow");
        assertThat(racingCarService.checkCarNameComma(car.getName())).isFalse();
    }
}
