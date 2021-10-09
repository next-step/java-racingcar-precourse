package racinggame;

import nextstep.utils.Console;

import racinggame.core.Player;
import racinggame.utils.GameUtil;
import racinggame.utils.ValidationUtil;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        List<Player> players;
        Integer playCount;
        boolean isValidateInput;

        do {

            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputPlayers = Console.readLine();

            String[] playerArray = inputPlayers.replaceAll(" ", "").split(",");
            isValidateInput = ValidationUtil.isValidateNameArray(playerArray);

            players = Player.of(playerArray);

        } while(!isValidateInput);

        do {

            System.out.println("시도할 회수는 몇회인가요?");
            String inputCount = Console.readLine();

            inputCount = inputCount.replaceAll(" ", "");
            isValidateInput = ValidationUtil.isValidateCount(inputCount);

            playCount = ValidationUtil.getValidateCount(inputCount);

        } while(!isValidateInput);

        System.out.println("\n실행 결과");

        for (int i = 0; i < playCount; i++) {
            GameUtil.playGame(players);
            System.out.println();
        }

        GameUtil.printLastResult(players);
    }

}
