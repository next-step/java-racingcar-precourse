package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.RacingCars;
import racingcar.utils.CarGeneratorUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class CarNameTest {

    private static final String JIN_WON = "진원";

    @Test
    void 유효한_이름인지_테스트() {
        ThrowingCallable overMaxLengthCase = () -> new CarName("여섯글자지롱");
        assertThatThrownBy(overMaxLengthCase).isInstanceOf(IllegalArgumentException.class);

        ThrowingCallable emptyCase = () -> new CarName("");
        assertThatThrownBy(emptyCase).isInstanceOf(IllegalArgumentException.class);

        ThrowingCallable nullCheckCase = () -> new CarName(null);
        assertThatThrownBy(nullCheckCase).isInstanceOf(IllegalArgumentException.class);

        CarName carName = new CarName(JIN_WON);
        String name = carName.getName();
        assertThat(name).isEqualTo(JIN_WON);
    }

    @Test
    void 각_자동차에게_이름_부여_및_중복_체크() {
        final List<Car> cars = CarGeneratorUtils.getCars("이런,안돼,중복,한다");
        final RacingCars racingCars = new RacingCars(cars);
        assertThat(racingCars.enterCars()).isEqualTo(4);

        final List<Car> multiRestCars = CarGeneratorUtils.getCars("이런,안돼,,");
        final RacingCars multiCars = new RacingCars(multiRestCars);
        assertThat(multiCars.enterCars()).isEqualTo(2);

        final ThrowingCallable duplicateCase = () -> CarGeneratorUtils.getCars("이런,이런");
        assertThatThrownBy(duplicateCase).isInstanceOf(IllegalArgumentException.class);

        final ThrowingCallable nullCase = () -> CarGeneratorUtils.getCars(null);
        assertThatThrownBy(nullCase).isInstanceOf(IllegalArgumentException.class);
    }

}
