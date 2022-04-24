package racingcar.model;

import java.util.ArrayList;
import java.util.StringJoiner;
import racingcar.RacingCar;

public class CurrentResult {
    String currentResult;

    public CurrentResult(ArrayList<RacingCar> cars) {
        this.currentResult = setCurrrentResult(cars);
    }

    String setCurrrentResult(ArrayList<RacingCar> cars) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (RacingCar car : cars) {
            stringJoiner.add(car.getPrintCurrentResult());
        }
        stringJoiner.add("");
        return stringJoiner.toString();
    }

    public String getResult() {
        return currentResult;
    }
}
