package racingcar.domain.response;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 1:40
 */
public class CarRaceResults {
    List<CarRaceResult> carRaceResults;

    public CarRaceResults(List<CarRaceResult> carRaceResults) {
        this.carRaceResults = carRaceResults;
    }

    public List<CarRaceResult> getCarRaceResults() {
        return carRaceResults;
    }
}
