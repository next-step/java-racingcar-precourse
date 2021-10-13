package racinggame.controller;

import racinggame.dto.GameTurnCntDTO;
import racinggame.dto.PlayerNamesDTO;
import racinggame.vo.Cars;
import racinggame.utils.WinnerMessageBuilder;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class IOController {
    private static final String ASK_PLAYER_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_TURN_CNT_MSG = "시도할 횟수는 몇회인가요?";
    private static final String RE_ASK_PLAYER_NAME_MSG = "플레이어들의 이름을 다시 입력하세요...";
    private static final String RE_ASK_GAME_TURN_CNT_MSG = "게임의 횟수를 다시 입력하세요...";
    private static final String ERROR_PLAYER_NAME_MSG = "[ERROR] 자동차의 이름은 1글자 이상 5글자 이하여야 합니다.";
    private static final String ERROR_GAME_TURN_CNT_MSG = "[ERROR] 게임 횟수는 양의 정수여야 합니다.";
    private static final String ERROR_GAME_NOT_SETUP_MSG = "게임이 정상적으로 준비되지 않았습니다. 관리자에게 문의바랍니다.";
    private static final String GAME_RESULT_MSG_PREFIX = "실행 결과";

    private InputView inputView;
    private OutputView outputView;

    public IOController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public PlayerNamesDTO AskPlayerNames() {
        this.outputView.write(ASK_PLAYER_NAME_MSG);

        return new PlayerNamesDTO(this.inputView.readLine());
    }

    public PlayerNamesDTO ReAskPlayerNames() {
        this.outputView.write(RE_ASK_PLAYER_NAME_MSG);

        return new PlayerNamesDTO(this.inputView.readLine());
    }

    public GameTurnCntDTO AskGameTurnCnt() {
        this.outputView.write(ASK_GAME_TURN_CNT_MSG);

        return new GameTurnCntDTO(this.inputView.readLine());
    }

    public GameTurnCntDTO ReAskGameTurnCnt() {
        this.outputView.write(RE_ASK_GAME_TURN_CNT_MSG);

        return new GameTurnCntDTO(this.inputView.readLine());
    }

    public void NotifyWinners(Cars winnerCars) {
        String winnerMsg = WinnerMessageBuilder.build(winnerCars);

        this.outputView.write(winnerMsg);
    }

    public void NotifyInvalidPlayerNames() {
        this.outputView.write(ERROR_PLAYER_NAME_MSG);
    }

    public void NotifyInvalidGameTurnCnt() {
        this.outputView.write(ERROR_GAME_TURN_CNT_MSG);
    }

    public void NotifyGameNotSetup() {
        this.outputView.write(ERROR_GAME_NOT_SETUP_MSG);
    }

    public void startShowingGameResult() {
        this.outputView.write(GAME_RESULT_MSG_PREFIX);
    }

    public void writeContent(String content) {
        this.outputView.write(content);
    }
}
