package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.vo.Name;
import racingcar.domain.car.vo.Position;

class CarTest {

    @Test
    void 움직인다() {
        final Name name = new Name("pobi");
        final Position position = new Position(0);
        final Car car = new Car(name, position);

        final Car movedCar = car.move();
        assertThat(movedCar).isEqualTo(new Car(name, position.increase()));
    }

    @Test
    void 위치가_같은지_테스트() {
        final Name name = new Name("pobi");
        final Position position = Position.zero();
        final Car car = new Car(name, position);

        boolean isSame = car.isSamePosition(Position.zero());
        assertThat(isSame).isTrue();
    }
    @Test
    void 위치가_다른지_테스트() {
        final Name name = new Name("pobi");
        final Position position = Position.zero();
        final Car car = new Car(name, position);

        boolean isSame = car.isSamePosition(new Position(1));
        assertThat(isSame).isFalse();
    }
}
