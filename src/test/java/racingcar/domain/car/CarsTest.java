package racingcar.domain.car;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.vo.Name;
import racingcar.domain.car.vo.Position;

class CarsTest {

    @Test
    void 인스턴스가_생성된다() {
        final Car car = new Car(new Name("pobi"), new Position(0));

        assertThatCode(() -> new Cars(new ArrayList<>(asList(car))))
            .doesNotThrowAnyException();
    }

    @Test
    void 차가_한대도_없을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 차가 최소 한대는 있어야 합니다.");
    }

    @Test
    void 자동차가_이동한다() {
        final Car car = new Car(new Name("pobi"), new Position(0));
        final Cars cars = new Cars(new ArrayList<>(asList(car)));

        final Cars movedCars = cars.move(() -> true);
        assertThat(movedCars).isEqualTo(new Cars(new ArrayList<>(asList(car.move()))));
    }

    @Test
    void 자동차가_이동하지_않는다() {
        final Car car = new Car(new Name("pobi"), new Position(0));
        final Cars cars = new Cars(new ArrayList<>(asList(car)));

        final Cars movedCars = cars.move(() -> false);
        assertThat(movedCars).isEqualTo(new Cars(new ArrayList<>(asList(car))));
    }

    @Test
    void 우승자를_찾는다() {
        final Cars cars = new Cars(new ArrayList<>(asList(
            new Car(new Name("pobi"), new Position(0)),
            new Car(new Name("crong"), new Position(1)),
            new Car(new Name("honux"), new Position(1))
        )));

        assertThat(cars.winners()).isEqualTo(new Cars(new ArrayList<>(asList(
            new Car(new Name("crong"), new Position(1)),
            new Car(new Name("honux"), new Position(1))
        ))));
    }
}
