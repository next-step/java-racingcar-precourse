package racingCar.repository;

import racingCar.domain.CarDTO;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    public boolean save(CarDTO carDTO);     // Car 객체를 repository에 저장

    public List<CarDTO> findAll();           // 저장된 모든 객체 반환

    public Optional<CarDTO> findOneMaxPos();        // position이 가장 큰 car 객체를 하나 반환
}
