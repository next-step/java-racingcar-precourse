package racingcar.domain;

import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingCarOutputView;
import racingcar.view.RacingGameInputView;

public class CarHandler {

    public static void round() {

        Cars cars = startInputCarName();
        int roundNumber = startInputRoundNumber();

        RacingCarOutputView.outputResult();

        for (int i = 0; i < roundNumber; ++i) {
            cars.runRound();
            System.out.println();
        }
        cars.getWinner();
    }

    private static Cars startInputCarName() {
        return new Cars(RacingGameInputView.inputCarName());
    }

    private static int startInputRoundNumber() {
        return RacingCarUtils.roundNumber(RacingGameInputView.inputCarTrackNumber());
    }
}
