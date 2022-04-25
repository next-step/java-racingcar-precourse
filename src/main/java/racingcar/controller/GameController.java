package racingcar.controller;

import racingcar.exception.IllegalArgumentException;
import racingcar.model.*;
import racingcar.view.Output;
import racingcar.view.UserInputView;

public class GameController {
    public static final String CAR_NAMES_INPUT_NOTICE_STR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_INPUT_NOTICE_STR = "시도할 회수는 몇회인가요?";
    public static final String RESULT_NOTICE_STR = "실행 결과";

    private final Round round;
    private final RacerGroup group;
    private final Output output = new Output();

    public GameController() {
        CarNames names = getValidCarNames();
        this.round = getValidRound();
        this.group = new RacerGroup();

        for (CarName name : names.getCarNames()) {
            Racer racer = new Racer(new Car(name));
            group.append(racer);
        }
    }

    public void run() {
        output.showNotice(RESULT_NOTICE_STR);

        while(!round.isFinished()) {
            round.playRound();
            group.runARace();
            output.showNotice(group.toStringCarDistanceByRacer());
        }

        WinnerGroup winnerGroup = new WinnerGroup(group);
        output.showNotice(winnerGroup.toStringFinalWinnerNames());
    }

    private Round getValidRound () {
        boolean isValid;
        String userInput;

        do {
            output.showNotice(ROUND_INPUT_NOTICE_STR);
            userInput = UserInputView.getUserInput();
            isValid = checkRoundUserInput(userInput);
        } while (!isValid);

        return new Round(userInput);
    }

    private boolean checkRoundUserInput(String userinput) {
        try {
            new Round(userinput);
            return true;
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return false;
        }
    }

    private CarNames getValidCarNames() {
        boolean isValid;
        String userInput;

        do {
            output.showNotice(CAR_NAMES_INPUT_NOTICE_STR);
            userInput = UserInputView.getUserInput();
            isValid = checkCarNamesUserInput(userInput);
        } while (!isValid);

        return new CarNames(userInput);
    }

    private boolean checkCarNamesUserInput(String userinput) {
        try {
            new CarNames(userinput);
            return true;
        } catch (IllegalArgumentException e) {
            output.showError(e);
            return false;
        }
    }
}
