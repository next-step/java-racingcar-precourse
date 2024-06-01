package service;

import domain.Car;
import dto.CarName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void testCreateCars() {
        CarName carName = new CarName("Car1,Car2,Car3");
        carService.createCars(carName);
        List<Car> cars = carService.getCars();

        assertEquals(3, cars.size());

        List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();

        // 입력한 자동차와 생성된 자동차 이름이 같은지 확인
        assertEquals(List.of("Car1", "Car2", "Car3"), carNames);
    }

    @Test
    void testMoveCars() {
        CarName carName = new CarName("Car1,Car2");
        carService.createCars(carName);

        for(int i = 0; i < 1000000; i++) {
            carService.moveCars();
        }
        List<Car> cars = carService.getCars();
        for (Car car : cars) {
            assertTrue(car.getDistance() > 500000 && car.getDistance() < 700000);
        }
    }

    @Test
    void testGetWinnerName() {
        CarName carName = new CarName("Car1,Car2,Car3");
        carService.createCars(carName);
        List<String> winners = carService.getWinnerName();

        // 모두 이동거리가 같은 경우
        assertEquals(3, winners.size());
        assertEquals(List.of("Car1", "Car2", "Car3"), winners);

        // 이동거리가 다른 경우
        while (winners.size() != 1) {
            carService.moveCars();
            winners = carService.getWinnerName();
        }

        int max = -1;
        String winner = "";
        for (Car car : carService.getCars()) {
            max = Math.max(max, car.getDistance());
            if (max == car.getDistance()) {
                winner = car.getName();
            }
        }

        assertEquals(List.of(winner), winners);
    }

}