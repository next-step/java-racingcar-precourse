package racinggame.controller;

import racinggame.model.Cars;
import racinggame.utils.WinnerMessageBuilder;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class IOController {
    private static final String ASK_PLAYER_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_TURN_COUNT_MSG = "시도할 횟수는 몇회인가요?";
    private static final String RE_ASK_PLAYER_NAME_MSG = "플레이어들의 이름을 다시 입력하세요...";
    private static final String RE_ASK_GAME_TURN_COUNT_MSG = "게임의 횟수를 다시 입력하세요...";
    private static final String ERROR_PLAYER_NAME_MSG = "[ERROR] 자동차의 이름은 1글자 이상 5글자 이하여야 합니다.";
    private static final String ERROR_GAME_TURN_COUNT_MSG = "[ERROR] 게임 횟수는 양의 정수여야 합니다.";

    private InputView inputView;
    private OutputView outputView;

    public IOController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public String AskPlayerNames() {
        this.outputView.write(ASK_PLAYER_NAME_MSG);

        return this.inputView.readLine();
    }

    public String AskValidPlayerNames() {
        this.outputView.write(RE_ASK_PLAYER_NAME_MSG);

        return this.inputView.readLine();
    }

    public String AskGameTurnCount() {
        this.outputView.write(ASK_GAME_TURN_COUNT_MSG);

        return this.inputView.readLine();
    }

    public String AskValidGameTurnCount() {
        this.outputView.write(RE_ASK_GAME_TURN_COUNT_MSG);

        return this.inputView.readLine();
    }

    public void NotifyInvalidPlayerNames() {
        this.outputView.write(ERROR_PLAYER_NAME_MSG);
    }

    public void NotifyInvalidGameTurnCnt() {
        this.outputView.write(ERROR_GAME_TURN_COUNT_MSG);
    }

    public void NotifyWinners(Cars winnerCars){
        String winnerMsg = WinnerMessageBuilder.build(winnerCars);

        this.outputView.write(winnerMsg);
    }
}
