package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private Cars cars;
    private int tryCount;
    private RaceSheet raceSheet;

    public CarRace(String carNames, String tryCount) {
        this.cars = new Cars(initCars(carNames));
        this.tryCount = parseInt(tryCount);
        this.raceSheet = new RaceSheet();
    }

    private static int parseInt(String tryCount) {
        if (!isNumeric(tryCount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(tryCount);
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<Car> initCars(String carNameString) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = carNameString.split(",");

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Cars> racingGameStart() {
        while (tryCount > 0) {
            cars.racing();
            raceSheet.addSheet(cars);
            tryCount--;
        }

        return raceSheet.getRaceSheets();
    }
}
