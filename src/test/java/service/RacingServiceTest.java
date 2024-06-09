package service;

import static org.assertj.core.api.Assertions.assertThat;

import model.Car;
import model.CarList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingServiceTest {

    @DisplayName("전진 테스트")
    @Test
    public void moveTest() {
        RacingService racingService = new RacingService();
        CarList carList = new CarList();
        Car car1 = new Car("Car1", 0);
        Car car2 = new Car("Car2", 2);
        carList.addCar(car1);
        carList.addCar(car2);

        RandomNumberGenerator rng = () -> 4; // 항상 전진하는 조건을 충족
        racingService.race(rng, carList);

        assertThat(car1.getDistance()).isEqualTo(1);
        assertThat(car2.getDistance()).isEqualTo(3);

    }

    @DisplayName("정지 테스트")
    @Test
    public void stopTest() {
        RacingService racingService = new RacingService();
        CarList carList = new CarList();
        Car car1 = new Car("Car1", 0);
        Car car2 = new Car("Car2", 2);
        carList.addCar(car1);
        carList.addCar(car2);

        RandomNumberGenerator rng = () -> 3; // 항상 전진하는 조건을 충족
        racingService.race(rng, carList);

        assertThat(car1.getDistance()).isEqualTo(0);
        assertThat(car2.getDistance()).isEqualTo(2);

    }
    @DisplayName("움직인 거리 중 가장 큰 값을 찾는 테스트")
    @Test
    void getMaxDistanceTest() {
        CarList carList = new CarList();
        Car car1 = new Car("Car1", 5);
        Car car2 = new Car("Car2", 3);
        carList.addCar(car1);
        carList.addCar(car2);

        RacingService racingService = new RacingService();

        int maxDistance = racingService.getMaxDistance(carList);
        assertThat(maxDistance).isEqualTo(5);
    }

    @DisplayName("우승자 테스트")
    @Test
    void getWinnerTest() {
        CarList carList = new CarList();
        Car car1 = new Car("Car1", 5);
        Car car2 = new Car("Car2", 5);
        carList.addCar(car1);
        carList.addCar(car2);

        RacingService racingService = new RacingService();

        assertThat(racingService.getWinner(5, carList)).containsExactlyInAnyOrder("Car1", "Car2");
    }
}