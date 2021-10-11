package racinggame;

import nextstep.utils.Console;

import racinggame.core.Attempt;
import racinggame.core.LastResult;
import racinggame.core.Game;
import racinggame.core.PlayerName;
import racinggame.core.PlayerNames;
import racinggame.core.Player;

import java.util.List;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private static List<Player> Players = null;
    private static Attempt attempt = null;

    public static void main(String[] args) {

        boolean isValidateInput = false;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputNames = Console.readLine();
            isValidateInput = canConvertInputNames(inputNames);
        } while (!isValidateInput);

        do {
            System.out.println("시도할 회수는 몇 회인가요?");
            String inputAttempt = Console.readLine();
            isValidateInput = canConvertInputCount(inputAttempt);
        } while (!isValidateInput);

        System.out.println("\n실행 결과");

        for (int i = 0; i < attempt.getAttemptNumber(); i++) {
            Game game = new Game(Players);
            game.play();
            System.out.println();
        }

        LastResult lastResult = new LastResult(Players);
        lastResult.printLastResult();
    }

    private static boolean canConvertInputNames(final String inputNames) {
        try {
            List<PlayerName> playerNames = new PlayerNames(inputNames).getPlayerNames();
            Players = Player.getPlayersByPlayerNames(playerNames);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return false;
        }
    }

    private static boolean canConvertInputCount(final String inputAttempt) {
        try {
            attempt = new Attempt(inputAttempt);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return false;
        }
    }

}
