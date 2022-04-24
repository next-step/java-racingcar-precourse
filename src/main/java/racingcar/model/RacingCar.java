package racingcar.model;

import racingcar.view.GamePrinter;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCar {

    public Map<String, Integer> racingCarRecords = new LinkedHashMap<>();

    public RacingCar(String[] cars) {
            for (String car : cars) {
                validateInputLength(car);
                String refinedCar = trimNameSpaces(car);
                racingCarRecords.put(refinedCar, 0);
            }
    }

    private String trimNameSpaces(String car) {
        return car.trim();
    }

    private void validateInputLength(String car) {
        if (car.length() > 5 || car.length() < 1) {
            GamePrinter.printErrorValidNames();
            // TODO : 예외처리 어떻게할거?
            throw new IllegalArgumentException("[ERROR]");
        }

    }

}
