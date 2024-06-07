package racingCar.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.CarDTO;

import java.util.List;


class CarMemoryRepositoryTest {
    CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

    @AfterEach
    void afterEach() {
        carMemoryRepository.clearCarDTOMap();
    }

    @Test
    @DisplayName("레포지토리 저장 테스트")
    void save() {
        CarDTO car = new CarDTO("car");
        boolean result = carMemoryRepository.save(car);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("모든 Car 검색 테스트")
    void findAll() {
        CarDTO car1 = new CarDTO("car1");
        CarDTO car2 = new CarDTO("car2");
        CarDTO car3 = new CarDTO("car3");
        carMemoryRepository.save(car1);
        carMemoryRepository.save(car2);
        carMemoryRepository.save(car3);

        List<CarDTO> result = carMemoryRepository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}