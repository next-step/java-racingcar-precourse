package racingCar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.repository.CarMemoryRepository;

class CarServiceTest {
    CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
    CarService carService = new CarService(carMemoryRepository);

    @AfterEach
    void afterEach() {
        carMemoryRepository.clearCarDTOMap();
    }

    @Test
    @DisplayName("입력에 대한 Car 객체 저장 테스트")
    void saveCars() {
        String inputNames = "Car1,car2,Car3";
        carService.saveCars(inputNames);
        Assertions.assertThat(carMemoryRepository.findAll().size()).isEqualTo(3);
    }
}