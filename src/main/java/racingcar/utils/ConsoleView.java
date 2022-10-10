package racingcar.utils;

import racingcar.entities.GameScenario;
import racingcar.entities.GameTimeInput;
import racingcar.entities.IsGameProceedWithOneCar;
import racingcar.entities.NamesInput;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleView {

    public NamesInput getNamesInput() {
        System.out.println(GameScenario.ASK_RACING_CARS_NAME.getGamePhrases());
        return new NamesInput(readLine());
    }

    public GameTimeInput getGameTimeInput() {
        System.out.println(GameScenario.ASK_GAME_TIMES.getGamePhrases());
        return new GameTimeInput(readLine());
    }
    public IsGameProceedWithOneCar getIfGameStartsWithOneCar() {
        System.out.println(GameScenario.ASK_GAME_STARTS_WITH_ONE_CAR.getGamePhrases());
        return new IsGameProceedWithOneCar(readLine());
    }

    public void announceWinner(String winnersName) {
        System.out.print(GameScenario.ANNOUNCE_WINNER.getGamePhrases() + winnersName);
    }
}
