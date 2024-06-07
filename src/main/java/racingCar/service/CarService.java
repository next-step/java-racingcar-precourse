package racingCar.service;

import racingCar.domain.CarDTO;
import racingCar.repository.CarRepository;

import java.util.Arrays;
import java.util.List;

public class CarService {
    private final CarRepository carRepository;

    /**
     * CarConfig로 부터 repository 객체를 가져와 의존성 주입
     * @param carRepository
     */
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;                     // DI
    }

    /**
     * 입력 받은 문자열을 통해 자동차 객체들 생성 및 저장
     * @param carNames
     */
    public void saveCars(String carNames) {
        List<String> nameList = splitCarNames(carNames);        // 입력된 문자열을 콤마(,) 기준 분리
        for(String name : nameList) {
            carRepository.save(new CarDTO(name));               // 이름을 통해 객체 생성
        }
    }

    /**
     * 입력 받은 문자열의 공백을 제거 후, 콤마로 split하여 List로 반환
     * @param carNames
     * @return name list
     */
    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(
                carNames.replaceAll("\\s+","")  // 공백 제거
                .split(",")
        );
    }
}
