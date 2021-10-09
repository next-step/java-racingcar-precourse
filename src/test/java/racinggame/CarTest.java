package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void carNameTest() {
        Car car = Car.of("kkjkk" , () -> true);
        assertThat(car.getCarName()).isEqualTo("kkjkk");

        assertThatThrownBy(
                () -> Car.of("superk" , () ->true)
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void carMoveTest() {
        Car moveCar = Car.of("kkjkk" , () -> true);
        Car notMoveCar = Car.of("kkjkk" , () -> false);

        moveCar.move();
        notMoveCar.move();

        assertThat(moveCar.matchPostion(1)).isTrue();
        assertThat(notMoveCar.matchPostion(0)).isTrue();

    }
    @Test
    void carsComparePositionTest() {
        Car moveCar = Car.of("kkjkk" , () -> true);
        Car notMoveCar = Car.of("kkjkk" , () -> true);

        moveCar.move();
        moveCar.move();
        notMoveCar.move();

        System.out.println(moveCar.comparePostion(notMoveCar));


    }
    @Test
    void carEqualsPositionTest() {
        Car moveCar = Car.of("kkjkk" , () -> true);
        Car notMoveCar = Car.of("kkjkk" , () -> true);

        moveCar.move();
        notMoveCar.move();

        System.out.println(moveCar.equalsPosition(notMoveCar));

    }

}