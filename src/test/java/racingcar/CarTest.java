package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("Position과 Name을 갖는다.")
    @Test
    void construct(){
        Car car = new Car(new Position(0), new Name("weno"));
        assertThat(car).isEqualTo(new Car(new Position(0), new Name("weno")));
    }

    @DisplayName("isMovable이 true면 position이 1 증가한다.")
    @Test
    void move_true(){
        Car car = new Car(new Position(0), new Name("weno"));
        MovableStrategy movableStrategy = () -> true;
        car.move(movableStrategy);

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @DisplayName("isMovable이 false면 position은 변함없다.")
    @Test
    void move_false(){
        Car car = new Car(new Position(0), new Name("weno"));
        MovableStrategy movableStrategy = () -> false;
        car.move(movableStrategy);

        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }
}
