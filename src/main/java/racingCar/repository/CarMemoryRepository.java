package racingCar.repository;

import racingCar.domain.CarDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMemoryRepository implements CarRepository {
    private final Map<String, CarDTO> carDTOMap = new HashMap<>();

    /**
     * 생성된 Car 객체를 map에 저장하는 메서드
      * @param carDTO 생성된 Car 객체
     * @return 이미 같은 이름의 객체가 존재하면 false, 아니면 true
     */
    @Override
    public boolean save(CarDTO carDTO) {
        String name = carDTO.getName();
        if(carDTOMap.containsKey(name)) {
            return false;
        }
        carDTOMap.put(name, carDTO);
        return true;
    }

    /**
     * map에 저장된 모든 객체들을 ArrayList로 반환하는 메서드
     * @return 모든 객체들이 저장된 ArrayList
     */
    @Override
    public List<CarDTO> findAll() {
        return new ArrayList<CarDTO>(carDTOMap.values());
    }
}
