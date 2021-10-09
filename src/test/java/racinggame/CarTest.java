package racinggame;

import nextstep.utils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racinggame.Fixture.CAR_A;

class CarTest {

    @RepeatedTest(10)
    void moved() {
        Car car = new Car(CAR_A);

        int number = Randoms.pickNumberInRange(0, 9);
        car.moved(number);

        if(number >= 4)
            assertThat(car.getPosition()).isEqualTo(1);
        if(number <= 3)
            assertThat(car.getPosition()).isEqualTo(0);

    }
}