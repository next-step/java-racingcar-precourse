package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    void 승자를_반환한다() {

        Participants participants = new Participants();

        Car car1 = new Car("pobi");
        car1.go();

        Car car2 = new Car("crong");
        car2.go();
        car2.go();

        Car car3 = new Car("honux");
        car3.go();
        car3.go();
        car3.go();

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        participants.setCars(cars);

        assertThat(participants.getWinner().get(0)).isEqualTo(car3.getName());
    }
}