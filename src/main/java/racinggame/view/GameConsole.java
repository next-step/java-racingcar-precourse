package racinggame.view;

import racinggame.environments.GlobalVariables;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.RacingGame;
import racinggame.utils.InputParser;

public class GameConsole {
    private static final int ILLEGAL_GAME_TURN_COUNT = -1;
    private static final String ASK_PLAYER_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ERROR_INPUT_PLAYER_NAME_MSG = "[ERROR] 자동차의 이름은 1글자 이상 5글자 이하여야 합니다. 이름을 다시 입력해주세요..";
    private static final String ASK_GAME_TURN_COUNT_MSG = "시도할 횟수는 몇회인가요?";
    private static final String ERROR_INPUT_GAME_TURN_COUNT_MSG = "[ERROR] 게임 횟수는 양의 정수여야 합니다. 다시 입력하세요...";
    private static final String WINNER_MSG_PREFIX = "최종 우승자는 ";
    private static final String WINNER_MSG_POSTFIX = " 입니다.";
    private static final String WINNER_MSG_DELIMITER = ",";

    private RacingGame racingGame;
    private InputParser inputParser;

    private InputView inputView;
    private OutputView outputView;

    private Cars playerCars;
    private int gameTurnCnt;

    public GameConsole() {
        this.racingGame = new RacingGame();
        this.inputParser = new InputParser();

        this.inputView = new InputView();
        this.outputView = new OutputView();

        this.playerCars = new Cars();
        this.gameTurnCnt = 0;
    }

    public void setup() {
        readPlayerNames();
        readGameTurnCount();
    }

    private void readPlayerNames() {
        String[] playerNames = readValidPlayerNames();

        for (String playerName : playerNames) {
            this.playerCars.add(new Car(playerName, 0));
        }
    }

    private String[] readValidPlayerNames() {
        this.outputView.write(ASK_PLAYER_NAME_MSG);

        String[] playerNames = null;
        while (playerNames == null) {
            String input = this.inputView.read();

            playerNames = getParsedPlayerNames(input);
        }

        return playerNames;
    }

    private String[] getParsedPlayerNames(String input) {
        try {
            String[] playerNames = this.inputParser.splitPlayerNames(input);

            return playerNames;
        } catch (IllegalArgumentException e) {
            this.outputView.write(ERROR_INPUT_PLAYER_NAME_MSG);
        }

        return null;
    }

    private void readGameTurnCount() {
        this.gameTurnCnt = readValidGameTurnCount();
    }

    private int readValidGameTurnCount(){
        this.outputView.write(ASK_GAME_TURN_COUNT_MSG);

        int turnCnt = ILLEGAL_GAME_TURN_COUNT;
        while (turnCnt < GlobalVariables.MIN_GAME_TURN_COUNT) {
            String input = this.inputView.read();

            turnCnt = getParsedGameTurnCount(input);
        }

        return turnCnt;
    }

    private int getParsedGameTurnCount(String gameTurnCntInput){
        try{
            return this.inputParser.parseGameTurnCnt(gameTurnCntInput);
        } catch (IllegalArgumentException e){
            this.outputView.write(ERROR_INPUT_GAME_TURN_COUNT_MSG);
        }

        return ILLEGAL_GAME_TURN_COUNT;
    }

    public void playGame() {
        Cars winnerCars = this.racingGame.play(this.playerCars, this.gameTurnCnt);

        String winnerMsg = buildWinnerMsg(winnerCars);

        this.outputView.write(winnerMsg);
    }

    private String buildWinnerMsg(Cars winnerCars) {
        StringBuilder builder = new StringBuilder();

        builder.append(WINNER_MSG_PREFIX);
        for (int i = 0; i < winnerCars.size(); i++) {
            Boolean isLastWinner = i == winnerCars.size() - 1;

            builder.append(buildWinnerMsgInternal(winnerCars.get(i), isLastWinner));
        }
        builder.append(WINNER_MSG_POSTFIX);

        return builder.toString();
    }

    private String buildWinnerMsgInternal(Car winnerCar, boolean isLastWinner) {
        String winnerMsg = winnerCar.getPlayerName();

        if (!isLastWinner) {
            winnerMsg += WINNER_MSG_DELIMITER;
        }

        return winnerMsg;
    }
}
