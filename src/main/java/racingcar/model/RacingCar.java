package racingcar.model;

import org.junit.platform.commons.util.StringUtils;
import racingcar.view.GamePrinter;

import java.util.*;


public class RacingCar {

    // TODO : 불변 지키게 하려면 어떻게 할 것인가?
    public Map<String, Integer> racingCarRecords = new LinkedHashMap<>();
    private final List<String> cacheDuplicateCars = new ArrayList<>();


    public RacingCar(String[] cars) {
        for (String car : cars) {
            validateEmpty(car);
            String refinedCar = trimNameSpaces(car);
            validateDuplicate(refinedCar);
            validateInputLength(refinedCar);
            racingCarRecords.put(refinedCar, 0);
        }
    }

    private void validateDuplicate(String car) {
        if (cacheDuplicateCars.contains(car)) {
            GamePrinter.printDuplicateName();
            throw new IllegalArgumentException();
        }
        cacheDuplicateCars.add(car);
    }

    private void validateEmpty(String read) {
        if (StringUtils.isBlank(read)) {
            GamePrinter.printEmptyName();
            throw new IllegalArgumentException();
        }
    }

    private String trimNameSpaces(String car) {
        return car.trim();
    }

    private void validateInputLength(String car) {
        if (car.length() > 5 || car.length() < 1) {
            GamePrinter.printErrorValidNames();
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
