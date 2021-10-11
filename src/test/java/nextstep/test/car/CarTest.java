package nextstep.test.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.domain.Car;
import racinggame.car.domain.CarName;
import racinggame.race.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car(new CarName("abcde"), new Position());
    }


}
