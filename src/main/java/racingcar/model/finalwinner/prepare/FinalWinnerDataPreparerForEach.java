package racingcar.model.finalwinner.prepare;

import racingcar.model.racing.car.RacingCar;

import java.util.Map;

public class FinalWinnerDataPreparerForEach {
    private final RacingCar racingCar;
    private final Map<String, Integer> advanceMap;

    public FinalWinnerDataPreparerForEach(RacingCar racingCar, Map<String, Integer> advanceMap) {
        this.racingCar = racingCar;
        this.advanceMap = advanceMap;
    }

    public int prepareAndGetMaxAdvance(int previousMaxAdvance) {
        String currentCarName = racingCar.getCarName().getValue();
        int currentAdvance = racingCar.getAdvance().getValue();
        advanceMap.put(currentCarName, currentAdvance);
        return Math.max(previousMaxAdvance, currentAdvance);
    }
}
