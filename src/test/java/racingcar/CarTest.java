package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("Test");
    }

    @Test
    void 전진() {
        CarCondition carcondition = car.run(5);
        assertThat(carcondition).isEqualTo(CarCondition.Forword);

    }

    @Test
    void 멈춤() {
        CarCondition carCondition = car.run(3);
        assertThat(carCondition).isEqualTo(CarCondition.Stop);


    }




}
