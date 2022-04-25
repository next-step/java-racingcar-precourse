package racingcar;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Cars {
    private static final String EMPTY_CAR_NAME = "[ERROR] 차량 이름이 비었습니다.";
    private static final String DUPLICATE_CAR_NAME= "[ERROR] 중복된 이름의 차가 존재합니다.";

    private LinkedHashMap<String, Car> cars;

    public Cars(LinkedHashMap<String, Car> cars) {
        this.cars = cars;
    }

    public static Cars create(CarNames carNames) {
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        for(CarName carName : carNames.getList()) {
            validateCarNameDuplication(carName, cars);
            cars.put(carName.getName(), Car.create(carName.getName()));
        }
        return new Cars(cars);
    }

    public LinkedHashMap<String, Car> getCollection() {
        return cars;
    }

    private static void validateCarNameDuplication(CarName carName, HashMap<String, Car> cars) {
        if(cars.containsKey(carName.getName())) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }
}
