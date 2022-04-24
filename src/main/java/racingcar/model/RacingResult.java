package racingcar.model;

import java.util.List;

public class RacingResult {
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";

    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public StringBuilder raceTurnResult() {
        StringBuilder turnResult = new StringBuilder();
        for (Car car : cars) {
            CarName carName = car.getName();
            turnResult.append(carName.getName())
                    .append(COLON)
                    .append(car.getPosition())
                    .append(NEW_LINE);
        }

        return turnResult;
    }
}
