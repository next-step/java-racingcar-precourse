package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void testInitialState() {
        Car car = new Car(new CarName("pobi"));
        assertThat(car.getName().toString()).isEqualTo("pobi");
        assertThat(car.getTravelDistance().toString()).isEqualTo("");
        assertThat(car.toString()).isEqualTo("pobi : ");
    }

    @Test
    void testToStringAfterTravel() {
        Car car = new Car(new CarName("crong"));
        car.travel();
        assertThat(car.toString()).isEqualTo("crong : -");
        car.travel();
        car.travel();
        assertThat(car.toString()).isEqualTo("crong : ---");
    }
}
