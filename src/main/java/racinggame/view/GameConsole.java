package racinggame.view;

import nextstep.utils.Console;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.RacingGame;
import racinggame.utils.InputParser;

public class GameConsole {
    private RacingGame racingGame;
    private InputParser inputParser;

    private Cars playerCars;
    private int gameTurnCnt;

    public GameConsole() {
        this.racingGame = new RacingGame();
        this.inputParser = new InputParser();

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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] playerNames = null;
        while (playerNames == null) {
            String input = Console.readLine();

            playerNames = getParsedPlayerNames(input);
        }

        return playerNames;
    }

    private String[] getParsedPlayerNames(String input) {
        try {
            String[] playerNames = this.inputParser.splitPlayerNames(input);

            return playerNames;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차의 이름은 1글자 이상 5글자 이하여야 합니다. 이름을 다시 입력해주세요..");
        }

        return null;
    }

    private void readGameTurnCount() {
        this.gameTurnCnt = readValidGameTurnCount();
    }

    private int readValidGameTurnCount(){
        System.out.println("시도할 횟수는 몇회인가요?");

        int turnCnt = -1;
        while (turnCnt <= 0) {
            String input = Console.readLine();

            turnCnt = getParsedGameTurnCount(input);
        }

        return turnCnt;
    }

    private int getParsedGameTurnCount(String gameTurnCntInput){
        try{
            return this.inputParser.parseGameTurnCnt(gameTurnCntInput);
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 게임 횟수는 양의 정수여야 합니다. 다시 입력하세요...");
        }

        return -1;
    }

    public void playGame() {
        Cars winnerCars = this.racingGame.play(this.playerCars, this.gameTurnCnt);

        String winnerMsg = buildWinnerMsg(winnerCars);

        System.out.println(winnerMsg);
    }

    private String buildWinnerMsg(Cars winnerCars) {
        StringBuilder builder = new StringBuilder();

        builder.append("최종 우승자는 ");
        for (int i = 0; i < winnerCars.size(); i++) {
            Boolean isLastWinner = i == winnerCars.size() - 1;

            builder.append(buildWinnerMsgInternal(winnerCars.get(i), isLastWinner));
        }
        builder.append(" 입니다.");

        return builder.toString();
    }

    private String buildWinnerMsgInternal(Car winnerCar, boolean isLastWinner) {
        String winnerMsg = winnerCar.getPlayerName();

        if (!isLastWinner) {
            winnerMsg += ",";
        }

        return winnerMsg;
    }
}
