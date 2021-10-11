package racinggame.view;

import nextstep.utils.Console;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.RacingGame;

public class GameConsole {
    private RacingGame racingGame;

    private Cars playerCars;
    private int gameTurnCnt;

    public GameConsole() {
        this.racingGame = new RacingGame();

        this.playerCars = new Cars();
        this.gameTurnCnt = 0;
    }

    public void setup() {
        readPlayerNames();
        readGameTurnCount();
    }

    private void readPlayerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] playerNames = input.split(",", 0);

        for (String playerName : playerNames) {
            this.playerCars.add(new Car(playerName, 0));
        }
    }

    private void readGameTurnCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();

        this.gameTurnCnt = Integer.parseInt(input);
    }

    public void playGame(){
        // TODO: 추후 사용자에게 입력받은 게임 턴수를 turnCnt로 전달해야 함
        Cars winnerCars = this.racingGame.play(this.playerCars, this.gameTurnCnt);
    }
}
