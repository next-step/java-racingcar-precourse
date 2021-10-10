package racinggame;

import racinggame.domain.AttemptCount;
import racinggame.domain.Racing;
import racinggame.view.Command;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        Command command = new Command();
        while (game(command));
    }

    public static boolean game(Command command) {
        boolean isGameNormal;
        try {
            Racing racing = Racing.createRacing(command.askCarNames());
            AttemptCount attemptCount = new AttemptCount(command.askAttemptCount());
            command.printResultMessage();
            racing.playRacing(command, attemptCount);
            command.printWinner(String.join(",", racing.getWinnerStr()));
            isGameNormal = false;
        } catch (IllegalArgumentException e) {
            command.printError();
            isGameNormal = true;
        }
        return isGameNormal;
    }
}
