package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RacingResult {
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";

    private List<Car> cars;
    private StringBuilder turnResult;

    public RacingResult(List<Car> cars) {
        this.turnResult = new StringBuilder();
        this.cars = cars;
    }

    public void raceTurnResult() {
        for (Car car : cars) {
            CarName carName = car.getName();
            turnResult.append(carName.getName())
                    .append(COLON)
                    .append(car.getPosition())
                    .append(NEW_LINE);
        }
    }

    public String getTurnResult() {
        return turnResult.toString();
    }
}
