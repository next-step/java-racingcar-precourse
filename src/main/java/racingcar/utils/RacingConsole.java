package racingcar.utils;

import racingcar.model.CarName;
import racingcar.model.Count;
import racingcar.model.Delimiter;
import racingcar.view.RacingCarPrint;

import java.util.List;

public class RacingConsole {

    public List<CarName> getCarName() {
        List<CarName> carNames;
        try {
            carNames = Delimiter.separateCarName(RacingCarPrint.inputRacingCarName());
        } catch (IllegalArgumentException e) {
            RacingCarPrint.println(e.getMessage());
            return getCarName();
        }
        return carNames;
    }

    public Count getCount() {
        Count count;
        try {
            count = new Count(inputAttemptCount());
        } catch (IllegalArgumentException e) {
            RacingCarPrint.println(e.getMessage());
            return getCount();
        }

        return count;
    }

    public void printResult(String result, String winnerResult) {
        RacingCarPrint.printRaceResult(result);
        RacingCarPrint.printFinalWinner(winnerResult);
    }

    private String inputAttemptCount() {
        return RacingCarPrint.inputAttemptCount();
    }

}
