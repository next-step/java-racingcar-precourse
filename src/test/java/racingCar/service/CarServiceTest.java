package racingCar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.CarDTO;
import racingCar.repository.CarMemoryRepository;

import java.util.List;

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

    @Test
    @DisplayName("최종 우승자 리스트 반환 테스트")
    void getWinner() {
        String inputNames = "car1,car2,car3";
        carService.saveCars(inputNames);
        List<CarDTO> carDTOList = carMemoryRepository.findAll();
        carDTOList.get(0).increasePos();
        carDTOList.get(1).increasePos();
        Assertions.assertThat(carService.getWinner().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Repository의 모든 Car 객체 리스트 반환 테스트")
    void getAllCars() {
        String inputNames = "car1,car2,car3,car4";
        carService.saveCars(inputNames);
        Assertions.assertThat(carService.getAllCars().size()).isEqualTo(4);
    }
}