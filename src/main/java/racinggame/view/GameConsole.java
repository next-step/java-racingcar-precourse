package racinggame.view;

import nextstep.utils.Console;
import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.model.RacingGame;

public class GameConsole {
    private Cars playerCars;
    private RacingGame racingGame;

    public GameConsole() {
        this.playerCars = new Cars();
        this.racingGame = new RacingGame();
    }

    public void setup() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] userNames = input.split(",", 0);

        for (String userName : userNames) {
            this.playerCars.add(new Car(userName, 0));
        }
    }

    public void playGame(){
        // TODO: 추후 사용자에게 입력받은 게임 턴수를 turnCnt로 전달해야 함
        Cars winnerCars = this.racingGame.play(this.playerCars, 10);
    }
}
