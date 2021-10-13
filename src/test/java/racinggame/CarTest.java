package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private String msgPreFix;

    @BeforeEach
    void setup() {
        car = new Car("tCar");
        msgPreFix = car.getName() + " : ";
    }

    @Test
    void stop() {
        assertThat(car.move(1)).isEqualTo(ActStatus.STOP);
    }

    @Test
    void go() {
        assertThat(car.move(7)).isEqualTo(ActStatus.GO);
    }

    @Test
    void position_0Go() {
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void position_1Go() {
        car.move(7);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void position_2Go_3Stop() {
        car.move(1);
        car.move(5);
        car.move(2);
        car.move(0);
        car.move(6);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void move_status_0Go() {
        car.move(1);
        assertThat(car.getMoveStatus()).isEqualTo(msgPreFix + ActStatus.STOP.getActExpress());
    }

    @Test
    void move_status_1Go() {
        car.move(7);
        assertThat(car.getMoveStatus()).isEqualTo(msgPreFix + ActStatus.GO.getActExpress());
    }

    @Test
    void move_status_2Go_3Stop() {
        car.move(1);
        car.move(5);
        car.move(2);
        car.move(0);
        car.move(6);
        assertThat(car.getMoveStatus()).isEqualTo(msgPreFix + "--");
    }
}
