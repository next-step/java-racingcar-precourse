package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceSheet {
    private final List<Cars> raceSheets;

    public RaceSheet() {
        this.raceSheets = new ArrayList<>();
    }

    public void addSheet(Cars cars) {
        Cars raceSheet = createSheet(cars);
        raceSheets.add(raceSheet);
    }

    private Cars createSheet(Cars cars) {
        List<Car> raceSheet = new ArrayList<>();
        for (Car car : cars.getCars()) {
            raceSheet.add(new Car(car.getName(), car.getMoveDistance()));
        }
        return new Cars(raceSheet);
    }

    public List<Cars> getRaceSheets() {
        return raceSheets;
    }
}
