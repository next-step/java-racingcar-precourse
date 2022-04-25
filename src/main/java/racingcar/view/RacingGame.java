package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidation;
import racingcar.domain.Player;

import java.util.HashSet;
import java.util.Set;

public class RacingGame {
    private static final RacingGame RACING_GAME = new RacingGame();
    private Set<Player> playerList = new HashSet<>();
    private int gameCount = 0;

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return RACING_GAME;
    }

    public void playRacing() {
        inputPlayer();
        inputGameCount();
    }

    public void inputPlayer() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputPlayerName = Console.readLine();
            String[] players = InputValidation.inputLengthValidation(inputPlayerName);
            for (String name : players) {
                Player player = new Player();
                player.setName(name);
                playerList.add(player);
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("[ERROR] " + iae.getMessage());
            inputPlayer();
        }
    }

    public void inputGameCount() {
            System.out.println("시도할 회수");
            String inputGameCount = Console.readLine();
            gameCount = Integer.parseInt(inputGameCount);
    }
}
