package racingcar.model.finalwinner.prepare;

import racingcar.model.racing.car.RacingCar;

import java.util.ArrayList;
import java.util.Map;

public class FinalWinnerDataPreparer {
    private final ArrayList<RacingCar> racingCars;
    private final Map<String, Integer> advanceMap;

    public FinalWinnerDataPreparer(ArrayList<RacingCar> racingCars, Map<String, Integer> advanceMap) {
        this.racingCars = racingCars;
        this.advanceMap = advanceMap;
    }

    public int prepareAndGetMaxAdvance() {
        int maxAdvance = 0;
        for (RacingCar racingCar : racingCars) {
            FinalWinnerDataPreparerForEach finalWinnerDataPreparerForEach =
                    new FinalWinnerDataPreparerForEach(racingCar, advanceMap);
            maxAdvance = finalWinnerDataPreparerForEach.prepareAndGetMaxAdvance(maxAdvance);
        }
        return maxAdvance;
    }
}
