package racingcar.controller;

import racingcar.exception.IllegalArgumentException;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.CarNames;
import racingcar.model.Player;
import racingcar.model.PlayerGroup;
import racingcar.model.Round;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public static final String REQUEST_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_INPUT_ROUND = "시도할 회수는 몇회인가요?";
    public static final String RESULT_NOTICE_STR = "실행 결과";

    private final OutputView outputView = new OutputView();
    private final PlayerGroup group;
    private final Round round;

    public RacingCarGameController() {
        CarNames names = getValidCarNames();
        this.round = validRound();
        this.group = new PlayerGroup();

        for (CarName name : names.getCarNames()) {
            Player player = new Player(new Car(name));
            group.append(player);
        }
    }

    public void run() {
        outputView.notice(RESULT_NOTICE_STR);

        while(!round.isFinished()) {
            round.playRound();
            group.runARace();
            outputView.notice(group.toStringCarDistanceByPlayer());
        }
        Winners winnerGroup = new Winners(group);
        outputView.notice(winnerGroup.toStringFinalWinnerNames());
    }

    private CarNames getValidCarNames() {
        boolean checkNames;
        String userInput;

        do {
            outputView.notice(REQUEST_INPUT_CAR_NAME);
            userInput = InputView.getUserInput();
            checkNames = checkCarNamesUserInput(userInput);
        } while (!checkNames);

        return new CarNames(userInput);
    }

    private boolean checkCarNamesUserInput(String userInput) {
        try {
            new CarNames(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            outputView.error(e);
            return false;
        }
    }

    private Round validRound () {
        boolean isValid;
        String userInput;

        do {
            outputView.notice(REQUEST_INPUT_ROUND);
            userInput = InputView.getUserInput();
            isValid = checkRoundUserInput(userInput);
        } while (!isValid);

        return new Round(userInput);
    }

    private boolean checkRoundUserInput(String userInput) {
        try {
            new Round(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            outputView.error(e);
            return false;
        }
    }
}