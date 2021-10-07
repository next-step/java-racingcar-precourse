package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void CarNameTest() {
        Car car = Car.of("kkjkk" , () ->0);
        assertThat(car.getCarName()).isEqualTo("kkjkk");

        assertThatThrownBy(
                () -> Car.of("superk" , () ->0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void CarMoveTest() {
        Car moveCar = Car.of("kkjkk" , () -> 4);
        Car notMoveCar = Car.of("kkjkk" , () -> 3);

        moveCar.move();
        notMoveCar.move();

        assertThat(moveCar.matchPostion(1)).isTrue();
        assertThat(notMoveCar.matchPostion(0)).isTrue();

    }

}