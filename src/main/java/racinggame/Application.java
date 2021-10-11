package racinggame;

import nextstep.utils.Console;

import racinggame.core.Attempt;
import racinggame.core.Convert;
import racinggame.core.LastResult;
import racinggame.core.Game;
import racinggame.core.Player;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Player> players;
        Attempt attempt;
        boolean isValidateInput;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputNames = Console.readLine();

            Convert convert = new Convert(inputNames);
            convert.checkConvertInputNames();
            players = convert.getConvertedPlayers();
            isValidateInput = convert.isConverted();
        } while (!isValidateInput);

        do {
            System.out.println("시도할 회수는 몇 회인가요?");
            String inputAttempt = Console.readLine();

            Convert convert = new Convert(inputAttempt);
            convert.checkConvertInputCount();
            attempt = convert.getAonvertedAttempt();
            isValidateInput = convert.isConverted();
        } while (!isValidateInput);

        System.out.println("\n실행 결과");

        for (int i = 0; i < attempt.getAttemptNumber(); i++) {
            Game game = new Game(players);
            game.play();
            System.out.println();
        }

        LastResult lastResult = new LastResult(players);
        lastResult.printLastResult();
    }

}
