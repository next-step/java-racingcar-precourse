package racingcar.model.finalwinner;

import racingcar.model.finalwinner.collect.FinalWinnerNamesCollector;
import racingcar.model.finalwinner.prepare.FinalWinnerDataPreparer;
import racingcar.model.racing.car.RacingCar;
import racingcar.model.racing.car.RacingCarsInGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FinalWinnersOfGame {
    private ArrayList<FinalWinnerName> finalWinnerNames;

    public FinalWinnersOfGame(RacingCarsInGame racingCarsInGame) {
        initialize(racingCarsInGame);
    }

    private void initialize(RacingCarsInGame racingCarsInGame) {
        finalWinnerNames = new ArrayList<>();
        ArrayList<RacingCar> racingCars = racingCarsInGame.getRacingCars();
        final Map<String, Integer> advanceMap = new HashMap<>();
        FinalWinnerDataPreparer finalWinnerDataPreparer = new FinalWinnerDataPreparer(racingCars, advanceMap);
        int maxAdvance = finalWinnerDataPreparer.prepareAndGetMaxAdvance();
        FinalWinnerNamesCollector finalWinnerNamesCollector = new FinalWinnerNamesCollector(advanceMap, maxAdvance);
        finalWinnerNames = finalWinnerNamesCollector.collect();
    }

    public ArrayList<FinalWinnerName> getFinalWinnerNames() {
        return finalWinnerNames;
    }
}
