package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    private static final int MIN_CAR_NAME = 1;
    private static final int MAX_CAR_NAME = 5;

    Map<String, Integer> track = new LinkedHashMap<>();

    public Map<String, Integer> paddock(String carsInput) {
        String[] cars = carsInput.split(",");
        if (cars.length > 0) {
            for (int i = 0; i < cars.length; i++) {
                countingCarName(cars[i], i);
            }
            return track;
        }
        throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
    }

    private void countingCarName(String carName, Integer index) {
        if (carName.length() < MIN_CAR_NAME) {
            throw new IllegalArgumentException("[ERROR] " + index + "번째 자동차의 이름이 없어용.");
        }
        if (carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("[ERROR] " + index + "번째 자동차의 이름은 최대 " + MAX_CAR_NAME + "자리까지 가능해요.");
        }
        settingCar(carName);
    }

    private void settingCar(String carName) {
        track.put(carName, 0);
    }

}
