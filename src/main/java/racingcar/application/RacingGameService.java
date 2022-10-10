package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.Round;
import racingcar.exception.RacinggameException;
import racingcar.ui.RacingGameInputView;
import racingcar.ui.RacingGameOutputView;

public class RacingGameService {

    public static CarList inputCarList() {
        try {
            return CarList.from(RacingGameInputView.inputCarList());
        } catch (RacinggameException racinggameException) {
            RacingGameOutputView.error(racinggameException);
            return inputCarList();
        }
    }

    public static Round inputRound() {
        try {
            return Round.from(RacingGameInputView.inputRound());
        } catch (RacinggameException racinggameException) {
            RacingGameOutputView.error(racinggameException);
            return inputRound();
        }
    }

    public static CarList racing(CarList carList, Round round) {
        RacingGameOutputView.printEmptyLine();
        RacingGameOutputView.printExecuteResult();

        for (int i = 0; i < round.getRound(); i++) {
            carList.forward();
            announcementOfRoundResult(carList);
        }

        return carList;
    }

    private static void announcementOfRoundResult(CarList carList) {
        for (Car car : carList.getCarList()) {
            RacingGameOutputView.printRoundResult(car);
            RacingGameOutputView.printEmptyLine();
        }
        RacingGameOutputView.printEmptyLine();
    }
}
