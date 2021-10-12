package racinggame.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends BaseTest<Car> {
    private final String carName = "car-01";

    @DisplayName("car 이름 비교 테스트")
    @Test
    void testGetName() {
        Car car = new Car(carName);
        assertThat(carName.equals(car.getName())).isTrue();
    }

    @DisplayName("car 전진 횟수 비교 테스트")
    @Test
    void testGetForwardMovementCount() {
        int initForwardMovementCount = 0;
        int forwardMovementCount = 0;

        Car car = new Car(carName);

        assertThat(car.getForwardMovementCount() == initForwardMovementCount).isTrue();

        setPrivateField(car, "forwardMovementCount", forwardMovementCount);

        assertThat(car.getForwardMovementCount() == forwardMovementCount).isTrue();
    }

    @DisplayName("car 비교 테스트")
    @Test
    void testCompare() {
        Car winnerCar = createCar("winnerCar", 10);
        Car car = createCar("car", 0);
        assertThat(winnerCar.compareTo(car) == 1).isTrue();
    }


    private Car createCar(String name, int forwardMovementCount) {
        Car car = new Car(carName);
        setPrivateField(car, "forwardMovementCount", forwardMovementCount);
        return car;
    }

}