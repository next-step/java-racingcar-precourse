package racingcar.view;

import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.MainController;
import racingcar.domain.Cars;
import racingcar.domain.RoundCount;
import racingcar.domain.Winners;

public class MainView {
    public static final String JOIN_STRING = ", ";

    public static void gameInfoForm(MainController mainController) {
        mainController.requestSetGameInfo(carNameForm(), roundCountForm());
    }

    public static void printResultInfo(MainController mainController) {
        PrintMessage.ROUND_RESULT_INFO.println();
        mainController.requestStartRound();
    }

    public static void printStatus(MainController mainController, List<String> statusList) {
        for (String status : statusList) {
            PrintMessage.custom(status);
        }

        PrintMessage.newLine();

        mainController.requestStartRound();
    }

    public static void printWinners(Winners winners) {
        PrintMessage.WINNERS_INFO.print();
        PrintMessage.custom(String.join(JOIN_STRING, winners.getNames()));
    }

    private static Cars carNameForm() {
        Cars cars = null;
        
        while (Objects.isNull(cars)) {
            PrintMessage.CAR_NAMES_FORM_INFO.println();
            cars = inputCarNames();
            PrintMessage.newLine();
        }

        return cars;
    }    

    private static RoundCount roundCountForm() {
        RoundCount roundCount = null;

        while (Objects.isNull(roundCount)) {
            PrintMessage.ROUND_COUNT_FORM_INFO.println();
            roundCount = inputRoundCount();
            PrintMessage.newLine();
        }

        return roundCount;
    }

    private static Cars inputCarNames() {
        Cars result = null;

        try {
            result = Cars.from(Console.readLine());
        } catch (IllegalArgumentException e) {
            PrintMessage.custom(e.getMessage());
        }

        return result;
    }

    private static RoundCount inputRoundCount() {
        RoundCount result = null;

        try {
            result = new RoundCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            PrintMessage.custom(e.getMessage());
        }

        return result;
    }
}
