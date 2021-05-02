package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void 전략이_참이면_이동이_가능하다(int move) {
        CarName carName = new CarName("길환DIY");
        Car car = new Car(carName, () -> true);

        for(int i = 0; i<move; i++) {
            car.move();
        }

        assertThat(car.getCurrentInfo())
                .isEqualTo(new CarHistory(carName, new Position(move)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void 전략이_거짓이면_이동이_불가능하다(int move) {
        CarName carName = new CarName("길환DIY");
        Car car = new Car(carName, () -> false);

        for(int i = 0; i<move; i++) {
            car.move();
        }

        assertThat(car.getCurrentInfo())
                .isEqualTo(new CarHistory(carName));
    }
}
