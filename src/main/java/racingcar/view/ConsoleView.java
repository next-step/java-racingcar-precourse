package racingcar.view;

import racingcar.controller.Game;
import racingcar.domain.*;

import java.util.List;

import static racingcar.domain.CarNames.COMMA;
import static racingcar.domain.RoundManager.FIRST_ROUND;

public class ConsoleView {

    public static void start() {
        Input input = new Input();
        input.input();

        Game game = new Game(input);
        game.run();

        printRoundsResult(game, input);
        printWinners(game);
    }

    private static void printRoundsResult(Game game, Input input) {
        Rounds rounds = game.getRoundsResult();

        for (int i = FIRST_ROUND; i <= input.getTotalRound(); i++) {
            Round round = rounds.getRound(new RoundNumber(i));

            printRoundResult(round, input.getCarNames());
            System.out.println();
        }
    }

    private static void printRoundResult(Round round, CarNames carNames) {
        String[] names = carNames.getCarNames();

        for (String name : names) {
            Mileage mileage = round.getMileage(new CarName(name));
            ResultOutput.printRoundResult(name, mileage);
        }
    }

    private static void printWinners(Game game) {
        Winners gameWinners = game.getWinners();

        List<CarName> winners = gameWinners.getWinners();
        StringBuilder stringBuilder = new StringBuilder();
        for (CarName carName : winners) {
            stringBuilder.append(carName).append(COMMA);
        }

        ResultOutput.printWinners(stringBuilder);
    }

}
