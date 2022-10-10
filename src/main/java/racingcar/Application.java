package racingcar;

import racingcar.application.RacingGameService;
import racingcar.domain.CarList;
import racingcar.domain.RacingGameResult;
import racingcar.domain.Round;
import racingcar.ui.RacingGameOutputView;

public class Application {
    public static void main(String[] args) {
        CarList carList = RacingGameService.inputCarList();
        Round round = RacingGameService.inputRound();
        RacingGameResult racingGameResult = RacingGameResult.of(RacingGameService.racing(carList, round));

        RacingGameOutputView.printWinner(racingGameResult);
    }
}
